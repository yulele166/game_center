package com.qn.gamecenter.bean.message.rep;

import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;

/**
 * @user 
 * @date 2016年6月20日
 */
public class RankAppInfoRep extends ShortAppInfoRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int rank;//排名
	
	

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
