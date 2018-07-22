package com.qn.gamecenter.bean.message.rep;

import com.qn.gamecenter.bean.message.rep.resource.GiftRep;

/**
 * 带着礼包数量的
 * @user 
 * @date 2016年6月27日
 */
public class GiftWithNumRep extends GiftRep {
	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
