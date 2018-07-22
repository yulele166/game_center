package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * @user 
 * @date 2016年6月20日
 */
@RequestMap(value="getComment")
public class GetCommentsReq extends RequestMessage{
	/**页面索引**/
	private int pi;
	/** 页面展示数量 **/
	private int ps;
	/** 软件id **/
	private int appId;
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
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	
}
