package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取某个软件详情
 * @user 
 * @date 2016年6月20日
 */
@RequestMap(value="getAppImgs")
public class GetAppImgsReq extends RequestMessage{
	/** /软件id **/
	private int appId;
	/** 软件具体信息id **/
	private int detailId;
	
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public int getDetailId() {
		return detailId;
	}
	public void setDetailId(int detailId) {
		this.detailId = detailId;
	}
	
}
