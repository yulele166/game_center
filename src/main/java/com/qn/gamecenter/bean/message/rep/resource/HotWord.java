package com.qn.gamecenter.bean.message.rep.resource;

import com.qn.gamecenter.bean.OpenType;

/**
 * 搜索热词 ，点击会直接跳转到搜索页面
 * @user 
 * @date 2016年6月13日
 */
public class HotWord extends ElementRep{
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public HotWord() {
		this.openType = OpenType.OPEN_SEARCH_PAGE;
	}
}
