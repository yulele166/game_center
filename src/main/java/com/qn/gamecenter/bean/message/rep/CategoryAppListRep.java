package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;

/**
 * 获取分类中的app集合
 * @user 
 * @date 2016年6月26日
 */
public class CategoryAppListRep extends SharePageRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4762564951862457472L;
	
	private List<ShortAppInfoRep> apps;

	public List<ShortAppInfoRep> getApps() {
		return apps;
	}

	public void setApps(List<ShortAppInfoRep> apps) {
		this.apps = apps;
	}
	
}
