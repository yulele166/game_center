package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取礼包详情
 * @user 
 * @date 2016年6月20日
 */
@RequestMap(value="getGifts")
public class GetGiftReq extends RequestMessage{
	/**软件id**/
	private int appId;

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}
	
}
