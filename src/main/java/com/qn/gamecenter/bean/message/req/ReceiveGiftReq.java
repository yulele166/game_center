package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * @user 
 * @date 2016年7月2日
 */
@RequestMap(value = "getGift")
public class ReceiveGiftReq extends RequestMessage {
	private int giftId;

	public int getGiftId() {
		return giftId;
	}

	public void setGiftId(int giftId) {
		this.giftId = giftId;
	}

}
