package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * @user 
 * @date 2016年6月24日
 */
@RequestMap(value="getHtmlList")
public class GetAppHtmlListReq extends RequestMessage{
	private int appId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
}
