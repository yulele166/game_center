package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.GiftRep;

/**
 * @user 
 * @date 2016年6月17日
 */
public class AppGiftRep extends SharePageRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4345993948724424000L;
	/**礼包列表 **/
	private List<GiftRep> gifts;

	public List<GiftRep> getGifts() {
		return gifts;
	}

	public void setGifts(List<GiftRep> gifts) {
		this.gifts = gifts;
	}
	public AppGiftRep() {
	}

}
