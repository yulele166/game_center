package com.qn.gamecenter.bean;

import com.qn.gamecenter.bean.message.req.BaseInfoReq;

/**
 * request的消息对应bean
 * 
 * @author 
 * @since 2015年11月23日 上午10:24:37
 */
public abstract class RequestMessage {
	private BaseInfoReq baseinfo;

	public BaseInfoReq getBaseInfo() {
		return baseinfo;
	}

	public void setBaseInfo(BaseInfoReq baseinfo) {
		this.baseinfo = baseinfo;
	}

}
