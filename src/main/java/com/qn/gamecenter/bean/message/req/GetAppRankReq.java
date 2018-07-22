package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 获取排行榜的请求
 * @user 
 * @date 2016年6月20日
 */
@RequestMap(value="getRank")
public class GetAppRankReq extends RequestMessage {
	/**排行榜类型**/
	private int type;
	/**页面索引**/
	private int pi;
	/**页面数量**/
	private int ps;
	
	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
}
