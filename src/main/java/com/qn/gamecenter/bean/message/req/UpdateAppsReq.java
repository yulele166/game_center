package com.qn.gamecenter.bean.message.req;

import java.util.List;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取本地软件的更新包
 * 
 * @user 
 * @date 2016年7月6日
 */
@RequestMap(value = "updateApps")
public class UpdateAppsReq extends RequestMessage {
	private List<String> pkgNames;// 客户端本地的安装软件包名集合

	public List<String> getPkgNames() {
		return pkgNames;
	}

	public void setPkgNames(List<String> pkgNames) {
		this.pkgNames = pkgNames;
	}

}
