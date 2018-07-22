package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.db.Rank;
import com.qn.gamecenter.bean.message.rep.AppRankNoShareRep;
import com.qn.gamecenter.bean.message.rep.AppRankRep;
import com.qn.gamecenter.bean.message.rep.RankAppInfoRep;
import com.qn.gamecenter.dao.AppInfoDAO;
import com.qn.gamecenter.dao.AppRankImgDAO;
import com.qn.gamecenter.dao.RankDAO;

/**
 * 排行榜相关操作
 * 
 * @user 
 * @date 2016年6月20日
 */
@Service
public class AppRankService {

	@Autowired
	private RankDAO rankDAO;

	@Autowired
	private AppInfoDAO appInfoDAO;

	@Autowired
	private AppRankImgDAO appRankImgDAO;

	@Autowired
	private SharePageService pageService;

	@Autowired
	private SharePageService sharePageService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private AppInfoService appInfoService;

	/**
	 * 获取排行榜信息
	 * 
	 * @param type
	 * @return
	 */
	public AppRankRep getRank(int type, int pi) {
		AppRankRep rep = getRankFromCache(type, pi);
		if (rep != null) {
			return rep;
		} else {
			rep = new AppRankRep();
			int start = sharePageService.getStart(pi, Constant.RANK_SIZE);
			int end = sharePageService.getEnd(pi, Constant.RANK_SIZE);
			// 排行榜头部信息 与 下面信息分开取，头部去前三位的
			if (start == 0) {
				start = Constant.RANK_UNDER_START;
				end = Constant.RANK_SIZE - Constant.RANK_UNDER_START;
			}
			List<Rank> ranks = rankDAO.getRankByType(type, start, end);
			List<RankAppInfoRep> apps = CollectionUtil.arrayList();
			Rank rank;
			for (int i = 0; i < ranks.size(); i++) {
				rank = ranks.get(i);
				RankAppInfoRep rankApp = appInfoDAO.getRankAppInfo(rank
						.getAppId());
				rankApp.setRank(i + 1);
				// 构建标签
				appInfoService.buildAppTag(rankApp, rank.getImgType(),
						rank.getAnimationType(), rank.getTagWord());
				apps.add(rankApp);
			}
			// 特殊处理 去掉前三个
			int totalNum = rankDAO.getTotal(type) - 3;
			rep.setApps(apps);
			pageService.buildSharePage(rep, pi, Constant.RANK_SIZE, totalNum);
			addRankToCache(rep, type, pi);
			return rep;
		}

	}

	/**
	 * 获取缓存中的排行榜
	 * 
	 * @param type
	 * @param pi
	 * @return
	 */
	public AppRankRep getRankFromCache(int type, int pi) {
		Object obj = redisService.getObjValue(RedisKey.RANK + type + ":" + pi);
		if (obj != null) {
			AppRankRep rep = (AppRankRep) obj;
			return rep;
		}
		return null;
	}

	/**
	 * 排行榜信息存入缓存
	 * 
	 * @param rep
	 * @param type
	 * @param pi
	 */
	public void addRankToCache(AppRankRep rep, int type, int pi) {
		redisService.setObjValue(RedisKey.RANK + type + ":" + pi, rep);
	}

	/**
	 * 获取排行榜头部信息
	 * 
	 * @param type
	 * @return
	 */
	public AppRankNoShareRep getRankTitle(int type) {
		List<Rank> ranks = rankDAO.getRankByType(type, 0,
				Constant.RANK_TITLE_SIZE);
		AppRankNoShareRep rep = new AppRankNoShareRep();
		List<RankAppInfoRep> apps = CollectionUtil.arrayList();
		Rank rank;
		for (int i = 0; i < ranks.size(); i++) {
			rank = ranks.get(i);
			RankAppInfoRep rankApp = appInfoDAO.getRankAppInfo(rank.getAppId());
			rankApp.setRank(i + 1);
			apps.add(rankApp);
		}
		rep.setApps(apps);
		rep.setImgUrl(appRankImgDAO.getRankImg(type));
		return rep;
	}
}
