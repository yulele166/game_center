package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.bean.RequestMessage;


/**
 * @user 
 * @date 2016年6月16日
 */
public class SharePageReq extends RequestMessage{
	private int appId;
	private int pi;
	private int ps;
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getPi() {
		return pi;
	}
	public void setPi(int pi) {
		this.pi = pi;
	}
	public int getPs() {
		return ps;
	}
	public void setPs(int ps) {
		this.ps = ps;
	}
	
}	
