package com.qn.gamecenter.bean.message.rep;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;

/**
 * 分页
 * @user 
 * @date 2016年6月15日
 */
public class SharePageRep extends ElementRep{
	/** 页面索引 **/
	protected int pi;
	/** 展示数量 **/
	protected int ps;
	
	protected long totalNum;
	
	protected int totalPage;
	
	
	public long getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(long totalNum) {
		this.totalNum = totalNum;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
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
	
}
