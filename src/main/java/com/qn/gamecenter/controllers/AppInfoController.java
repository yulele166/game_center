package com.qn.gamecenter.controllers;

import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppImgListRep;
import com.qn.gamecenter.bean.message.rep.AppRankRep;
import com.qn.gamecenter.bean.message.rep.CategoryAppListRep;
import com.qn.gamecenter.bean.message.rep.resource.AppInfoRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.bean.message.req.GetAppImgsReq;
import com.qn.gamecenter.bean.message.req.GetAppInfoReq;
import com.qn.gamecenter.service.AppImgService;
import com.qn.gamecenter.service.AppInfoService;

/**
 * 软件相关接口
 * 
 * @user 
 * @date 2016年6月3日
 */
@Path("/app/")
public class AppInfoController {
	@Autowired
	private AppInfoService appInfoService;

	@Autowired
	private AppImgService appImgService;

	/**
	 * 获取软件详情
	 * 
	 * @param req
	 * @return {@link AppInfoRep}
	 */
	@Get("/getApp")
	public AppInfoRep getAppInfo(GetAppInfoReq req) {
		return appInfoService.getAppInfo(req.getAppId(), req.getDetailId());
	}

	/**
	 * 获取软件截屏图
	 * 
	 * @param req
	 * @return {@link AppImgListRep}a
	 */
	@Get("/getAppImg")
	public AppImgListRep getAppImgs(GetAppImgsReq req) {
		return appImgService.getImages(req.getAppId());
	}

	/**
	 * 获取软件简介
	 * 
	 * @param req
	 * @return
	 */
	@Get("/getShortApp")
	public ShortAppInfoRep getShortApp(GetAppInfoReq req) {
		return appInfoService.getShortAppInfo(req.getAppId());
	}
	
	@Get("/getRecommendApps")
	public CategoryAppListRep getRecommendApp(Invocation inv){
		CategoryAppListRep rep = new CategoryAppListRep();
		List<ShortAppInfoRep> apps =  appInfoService.getRecommendApp(inv);
		rep.setApps(apps);
		return rep;
	}
}
