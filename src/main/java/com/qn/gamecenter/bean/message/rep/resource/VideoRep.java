package com.qn.gamecenter.bean.message.rep.resource;

import com.qn.gamecenter.bean.OpenType;


/**
 * 视频
 * @user 
 * @date 2016年6月12日
 */
public class VideoRep extends ElementRep{
	private int appId;
	private String address;
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
	public VideoRep() {
		this.openType = OpenType.OPEN_VIDEO;
	}
}
