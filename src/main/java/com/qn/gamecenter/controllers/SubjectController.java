package com.qn.gamecenter.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.RequestMessage;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.SubJect;
import com.qn.gamecenter.bean.message.req.GetShareInfoReq;
import com.qn.gamecenter.bean.message.req.GetSubject;
import com.qn.gamecenter.service.BrowTimesService;
import com.qn.gamecenter.service.SubjectService;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * 专题相关接口
 * 
 * @user 
 * @date 2016年6月12日
 */
@Path("/subject/")
public class SubjectController {


	@Autowired
	private SubjectService subService;

	@Autowired
	private BrowTimesService browTimesService;
	
	

	/**
	 * 获取精品页
	 * 
	 * @return
	 */
	@Get("/getQualityPage")
	public SubJect getQualityPage(GetShareInfoReq req) {
		int startTimes = req.getBaseInfo().getStartTimes();
		return subService.getQualityAppPage(req.getPi(),startTimes);
	}

	/**
	 * 获取专题中的内容
	 * 
	 * @return
	 */
	@Get("/getSubject")
	public SubJect getSubject(GetSubject req) {
		// browTimesService.addTimes(req.getSubId());
		subService.addOpenSubjectTimes(req.getSubId());
		return subService.getSubjectWithSharePage(req.getSubId(), req.getPi());
	}

	/**
	 * 精品页表头
	 * 
	 * @return
	 */
	@Get("/getQualityPageTitle")
	public SubJect getSubjectById(Invocation inv) {
		RequestMessage message = (RequestMessage)inv.getAttribute("message");
		return subService.getQualityPageTitle(message.getBaseInfo().getStartTimes());
	}

	/**
	 * 获取发现页面
	 * 
	 * @return
	 */
	@Get("/getDiscoveryPage")
	public SubJect getDisconveryPage(GetShareInfoReq req) {
		return subService.getDiscoveryPage(req.getPi(), Integer.parseInt(req.getBaseInfo().getAppVersion()));
	}


	/**
     * 获取搜素热词
	 * 
	 * @return
	 */
	@Get("/getSearchSubject")
	public SubJect getSearchSubject() {
		return subService.getSearchSubject();
	}

	/**
	 * 获取导航栏下面 的tab
	 * 
	 * @return
	 */
	@Get("/getTab")
	public ElementRep getTab(Invocation inv) {
		return subService.getTab(inv);

	}

}
