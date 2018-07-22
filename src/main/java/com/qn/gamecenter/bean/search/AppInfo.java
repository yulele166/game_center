package com.qn.gamecenter.bean.search;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @user 
 * @date 2016年6月7日
 */
public class AppInfo {
	@Field
	private String appName;
	@Field
	private int id;
	@Field
	private String icon;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
