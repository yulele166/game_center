package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取更新信息
 * 
 * @user 
 * @date 2016年7月5日
 */
@RequestMap(value="getPkg")
public class GetPkgReq extends RequestMessage {
	private String signature;// 签名

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}
