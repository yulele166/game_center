package com.qn.gamecenter.bean.message.rep;

import java.util.List;

/**
 * 排行榜返回数据
 * 
 * @user 
 * @date 2016年6月20日
 */
public class AppRankRep extends SharePageRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = -315595577936864212L;
	private List<RankAppInfoRep> apps;

	public List<RankAppInfoRep> getApps() {
		return apps;
	}

	public void setApps(List<RankAppInfoRep> apps) {
		this.apps = apps;
	}

}
