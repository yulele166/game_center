package com.qn.gamecenter.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppHtmlListRep;
import com.qn.gamecenter.bean.message.rep.AppHtmlPageRep;
import com.qn.gamecenter.bean.message.req.GetAppHtmlListReq;
import com.qn.gamecenter.bean.message.req.GetHtmlsReq;
import com.qn.gamecenter.service.HtmlPageService;

/**
 * @user 
 * @date 2016年6月15日
 */
@Path("/htmlpage/")
public class HtmlPageController {
	@Autowired
	private HtmlPageService htmlPageService;

	
	/**
	 * 获取对应类型的页面集合
	 * @param req 
	 * @return {@link AppHtmlPageRep}
	 */
	@Get("getHtmls")
	public AppHtmlPageRep getHtmls(GetHtmlsReq req) {
		return htmlPageService.getHtmls(req.getAppId(), req.getPi(),
				req.getType());
	}
	/**
	 * 获取攻略和活动的页面集合
	 * @param req
	 * @return
	 */
	@Get("getUnionHtmls")
	public AppHtmlListRep getHtmlList(GetAppHtmlListReq req){
		return htmlPageService.getHtmlList(req.getAppId());
	}
	
	

}
