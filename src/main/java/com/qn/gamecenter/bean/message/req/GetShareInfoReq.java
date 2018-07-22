package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 分页获取某一接口信息（发现，精品页）
 * 
 * @user 
 * @date 2016年7月10日
 */
@RequestMap(value = "getQualityPage,getDisconveryPage,getDiscoverySecondPage")
public class GetShareInfoReq extends RequestMessage {
	private int pi;// 获取第几页的内容

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}
}
