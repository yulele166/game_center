package com.qn.gamecenter.service;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.bean.ErrorCodeConstant;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.ResponseMessage;
import com.qn.gamecenter.bean.db.DbPackage;
import com.qn.gamecenter.bean.message.rep.UpdateAppInfoRep;
import com.qn.gamecenter.bean.message.rep.UpdateAppRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.bean.message.req.BaseInfoReq;
import com.qn.gamecenter.bean.message.req.GetPkgReq;
import com.qn.gamecenter.bean.message.req.UpdateAppsReq;
import com.qn.gamecenter.dao.AppInfoDAO;
import com.qn.gamecenter.dao.PackageDAO;

import net.paoding.rose.web.Invocation;
/**
 * 软件升级更新相关逻辑
 * 
 * @user 
 * @date 2016年7月5日
 */
@Service
public class UpdateService {

	@Autowired
	private AppInfoDAO appInfoDAO;

	private static List<Integer> GREP_VERSIONS = CollectionUtil.arrayList();//需要屏蔽的版本号
	@Autowired
	private MessageService messageService;
	@Autowired
	private RedisService redisService;

	@Autowired
	private PackageDAO dao;
	
	private String DEFAULT_CHANELL = "1010";

	/**
	 * 获取渠道对应的最新升级包，需校验签名
	 * 
	 * @param version
	 *            版本号
	 * @param channel
	 *            渠道号
	 * @param sign
	 *            签名
	 * @return
	 */
	private DbPackage getDbPackage(String version, String channel, String sign) {
		int versionInt = Integer.parseInt(version);
		ConcurrentHashMap<String, DbPackage> DBPACKAGE_INFOS = initDbPackageMap();
		// 判断是否是屏蔽的版本号
		if (GREP_VERSIONS.contains(versionInt)) {
			return null;
		}
		// 是否有该渠道的升级包
		if (!DBPACKAGE_INFOS.containsKey(channel)) {
			channel = DEFAULT_CHANELL;
		}

		DbPackage dbDbPackage = DBPACKAGE_INFOS.get(channel);
		if (!dbDbPackage.getSign().equals(sign)) {
			return null;
		}
		if (versionInt < dbDbPackage.getVersion()) {
			return dbDbPackage;
		}
		return null;
	}

	/**
	 * 初始化安装包的map集合
	 */
	public synchronized ConcurrentHashMap<String, DbPackage> initDbPackageMap() {
		ConcurrentHashMap<String, DbPackage> DBPACKAGE_INFOS = CollectionUtil.concurrentMap();
		Object obj = redisService.getObjValue(RedisKey.UPDATE_PKG_INFO);
		if (obj!=null) {
			DBPACKAGE_INFOS = (ConcurrentHashMap<String, DbPackage>)obj;
		}else {
			List<DbPackage> DbPackages = dao.getAllLastPackages();
			for (DbPackage dbDbPackage : DbPackages) {
				DBPACKAGE_INFOS.put(dbDbPackage.getChannel(), dbDbPackage);
			}
			redisService.setObjValue(RedisKey.UPDATE_PKG_INFO, DBPACKAGE_INFOS);
		}
		// 升级包需要屏蔽的版本号
		GREP_VERSIONS = dao.getGrepVersions();
		return DBPACKAGE_INFOS;

	}
	
	
	

	/**
	 * 获取需要下载的安装包地址 根据渠道，匹配当前渠道最新的包，需校验签名
	 */
	public UpdateAppRep updateApp(GetPkgReq req, Invocation inv) {
		// 获取用户基本信息
		BaseInfoReq baseInfo = req.getBaseInfo();
		// 用户基本信息
		String version = baseInfo.getAppVersion();// 软件包当前版本
		String channel = baseInfo.getChannel();// 渠道
		String sign = req.getSignature();
		DbPackage dbDbPackage = getDbPackage(version, channel, sign);
		// 没有更新
		if (dbDbPackage == null) {
			ResponseMessage messageRep = messageService.getRepMessage(inv);
			messageRep.setStatus(ErrorCodeConstant.NO_UPDATE);
			return null;
		}
		UpdateAppRep app = new UpdateAppRep();
		app.setCrc(dbDbPackage.getCrc());
		app.setDescript(dbDbPackage.getDescs());
		app.setDownloadUrl(dbDbPackage.getAddress());
		app.setPackageName(dbDbPackage.getPackageName());
		app.setSize(dbDbPackage.getVersionSize());
		app.setVersion(dbDbPackage.getVersion());
		app.setVersionName(dbDbPackage.getVersionName());
		app.setName(dbDbPackage.getName());
		app.setImgUrl(dbDbPackage.getImgUrl());
		return app;
	}

	/**
	 * 客户端本地所有下载软件的更新
	 * 
	 * 
	 * @param req
	 */
	public List<UpdateAppInfoRep> updateApps(UpdateAppsReq req) {
		BaseInfoReq  baseInfo = req.getBaseInfo();
		int version = Integer.parseInt(baseInfo.getAppVersion());
		List<String> pkgNames = req.getPkgNames();
		List<UpdateAppInfoRep> apps =null;
		//版本控制
		if(version < 50206){
			apps = appInfoDAO.getOldUpAppByPkgNames(pkgNames);
		}else{
			apps = appInfoDAO.getUpAppByPkgNames(pkgNames);
		}
		return apps;
	}
}
