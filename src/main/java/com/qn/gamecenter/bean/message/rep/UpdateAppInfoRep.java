package com.qn.gamecenter.bean.message.rep;

import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;

/**
 * @user 
 * @date 2017年3月20日
 */
public class UpdateAppInfoRep extends ShortAppInfoRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int auto;

	public int getAuto() {
		return auto;
	}

	public void setAuto(int auto) {
		this.auto = auto;
	}

}
