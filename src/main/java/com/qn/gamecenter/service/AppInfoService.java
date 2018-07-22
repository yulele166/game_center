package com.qn.gamecenter.service;

import java.util.List;

import net.paoding.rose.web.Invocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.ModelType;
import com.qn.gamecenter.bean.RequestMessage;
import com.qn.gamecenter.bean.message.rep.resource.AppInfoRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.bean.message.req.BaseInfoReq;
import com.qn.gamecenter.dao.AppInfoDAO;

/**
 * 软件信息服务类
 * 
 * @user 
 * @date 2016年6月2日
 */
@Service
public class AppInfoService {
	@Autowired
	private AppInfoDAO appInfoDAO;

	@Autowired
	private CommentService commentService;

	@Autowired
	private AppImgService appImgService;

	@Autowired
	private VideoService videoService;

	@Autowired
	private SharePageService pageService;

	@Autowired
	private HtmlPageService htmlPageService;

	@Autowired
	private GiftService giftService;

	@Autowired
	private CategoryService categoryService;

	/**
	 * 获取软件详情
	 * 
	 * @param appId
	 * @param detailId
	 * @return
	 */
	public AppInfoRep getAppInfo(int appId, int detailId) {
		AppInfoRep appInfo = appInfoDAO.getAppInfoById(appId);
		setTab(appInfo, appId);
		return appInfo;
	}

	private void setTab(AppInfoRep appInfo, int appId) {
		int num = htmlPageService.getHtmlNums(appId);
		if (num != 0) {
			appInfo.setHasHtml(1);
		}
		int giftNum = giftService.getGiftNum(appId);
		if (giftNum != 0) {
			appInfo.setHasGift(1);
		}

	}

	/**
	 * 获取软件详情简介
	 * 
	 * @param appId
	 * @return
	 */
	public ShortAppInfoRep getShortAppInfo(int appId) {
		return appInfoDAO.getShortAppInfo(appId);
	}

	/**
	 * 通过appName获取软件简介
	 * 
	 * @param appName
	 * @return
	 */
	public ShortAppInfoRep getShortAppInfo(String appName) {
		return appInfoDAO.getShortAppInfoByAppName(appName);
	}

	/**
	 * 根据软件id 获取软件信息
	 * 
	 * 
	 * @param appIds
	 * @return
	 */
	public List<ShortAppInfoRep> getApps(List<Integer> appIds) {
		return appInfoDAO.getAppByAppIds(appIds);
	}

	/**
	 * 获取分类的软件信息
	 * 
	 * @param cid
	 * @param start
	 * @param end
	 * @return
	 */
	public List<ShortAppInfoRep> getAppInfos(int cId, int start, int end) {
		List<ShortAppInfoRep> apps = appInfoDAO.getAppInfos(cId, start, end);
		return apps;
	}

	/**
	 * 获取指定分类的软件总数
	 * 
	 * @param cId
	 * @return
	 */
	public int getCategoryTotalNum(int cId) {
		return appInfoDAO.getTotalNum(cId);
	}

	/**
	 * 构建图标上的标签
	 * 
	 * @param app
	 * @param imgType
	 * @param animotionType
	 * @param word
	 */
	public void buildAppTag(ShortAppInfoRep app, int imgType,
			int animationType, String word) {
		app.setAnimationType(animationType);
		app.setImgType(imgType);
		app.setWord(word);
	}

	/**
	 * 获取推荐安装app
	 * 
	 * @param type
	 */
	public List<ShortAppInfoRep> getRecommendApp(Invocation inv) {

		RequestMessage message = (RequestMessage) inv.getAttribute("message");

		BaseInfoReq baseInfo = message.getBaseInfo();
		// 获取机型
		int type = getMobileType(baseInfo.getBrand());
		List<Integer> appIds = appInfoDAO.getRecomendAppInfo(type);
		List<ShortAppInfoRep> apps = appInfoDAO.getAppByAppIds(appIds);
		return apps;
	}

	/**
	 * 根据厂商获取类型
	 * 
	 * @param brand
	 * @return
	 */
	private int getMobileType(String brand) {
		if ("".equals(brand) || brand == null) {
			// 0代表错误
			return 0;
		}
		String brandLow = brand.toLowerCase();
		if (brandLow.equals("huawei") || brandLow.equals("honor")) {
			return ModelType.HUAWEI;
		}
		return ModelType.NOTHUAWEI;
	}
}
