package com.qn.gamecenter.controllers;

import java.util.List;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.UpdateAppInfoRep;
import com.qn.gamecenter.bean.message.rep.UpdateAppRep;
import com.qn.gamecenter.bean.message.req.GetPkgReq;
import com.qn.gamecenter.bean.message.req.UpdateAppsReq;
import com.qn.gamecenter.service.UpdateService;

/**
 * 升级相关接口
 * 
 * @user 
 * @date 2016年7月5日
 */
@Path("/package")
public class PackageController {
	@Autowired
	private UpdateService updateService;

	/**
	 * 检测自身是否有更新
	 * 
	 * @param req
	 * @return
	 */
	@Get("/getPkg")
	public UpdateAppRep getPkg(GetPkgReq req, Invocation inv) {
		return updateService.updateApp(req, inv);
	}

	/**
	 * 客户端本地软件列表更新
	 * 
	 * @param req
	 */
	@Get("/updateApps")
	public List<UpdateAppInfoRep> updateApps(UpdateAppsReq req) {
		return updateService.updateApps(req);
	}

}
