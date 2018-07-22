package com.qn.gamecenter.bean.message.rep;

import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;


import java.util.List;

/**
 * html页面的集合数据
 * @user 
 * @date 2016年6月17日
 */
public class AppHtmlPageRep extends SharePageRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3063997025384735382L;
	private List<HtmlPageRep> htmls;

	public List<HtmlPageRep> getHtmls() {
		return htmls;
	}

	public void setHtmls(List<HtmlPageRep> htmls) {
		this.htmls = htmls;
	}
	
}
