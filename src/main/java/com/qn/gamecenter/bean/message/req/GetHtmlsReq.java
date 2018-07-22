package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取html页面集合的请求
 * @user 
 * @date 2016年6月17日
 */
@RequestMap(value="getHtmls")
public class GetHtmlsReq extends RequestMessage{
	/** 页码 **/
	private int  pi;
	/** 每页数量 **/
	private int ps;
	/** html类型 **/
	private int type;
	/** 软件id **/
	private int appId;
	
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
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
}
