package com.qn.gamecenter.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppRankNoShareRep;
import com.qn.gamecenter.bean.message.rep.AppRankRep;
import com.qn.gamecenter.bean.message.req.GetAppRankReq;
import com.qn.gamecenter.bean.message.req.GetRankTitleReq;
import com.qn.gamecenter.service.AppRankService;

/**
 * 排行榜相关接口
 * 
 * @user 
 * @date 2016年6月20日
 */
@Path("/rank/")
public class RankController {

	@Autowired
	private AppRankService appRankService;

	/**
	 * 获取排行榜
	 * 
	 * @param req
	 * @return
	 */
	@Get("/getRank")
	public AppRankRep getRank(GetAppRankReq req) {

		return appRankService.getRank(req.getType(), req.getPi());
	}

	@Get("/getRankTitle")
	public AppRankNoShareRep getRankTitle(GetRankTitleReq req) {
		return appRankService.getRankTitle(req.getType());
	}
}
