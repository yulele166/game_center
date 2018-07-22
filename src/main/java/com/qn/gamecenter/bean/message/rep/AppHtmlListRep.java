package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;

/**
 * 软件详情页面的攻略活动页面集合
 * 
 * @user 
 * @date 2016年6月24日
 */
public class AppHtmlListRep extends ElementRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 693748738222343007L;
	/** 活动页面 */
	private List<HtmlPageRep> actPages;
	/** 攻略页面 **/
	private List<HtmlPageRep> strPages;

	public List<HtmlPageRep> getActPages() {
		return actPages;
	}

	public void setActPages(List<HtmlPageRep> actPages) {
		this.actPages = actPages;
	}

	public List<HtmlPageRep> getStrPages() {
		return strPages;
	}

	public void setStrPages(List<HtmlPageRep> strPages) {
		this.strPages = strPages;
	}

	public AppHtmlListRep() {
	}
}
