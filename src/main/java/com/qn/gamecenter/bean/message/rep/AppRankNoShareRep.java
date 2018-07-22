package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;

/**
 * @user 
 * @date 2016年6月25日
 */
public class AppRankNoShareRep extends ElementRep {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8576578328377051783L;
	private List<RankAppInfoRep> apps;

	public List<RankAppInfoRep> getApps() {
		return apps;
	}

	public void setApps(List<RankAppInfoRep> apps) {
		this.apps = apps;
	}

}
