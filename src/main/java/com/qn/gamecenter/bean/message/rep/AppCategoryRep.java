package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;

/**
 * @user 
 * @date 2016年6月24日
 */
public class AppCategoryRep extends ElementRep {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<CategoryRep> cs;

	private List<ElementRep> titles;

	public List<ElementRep> getTitles() {
		return titles;
	}

	public void setTitles(List<ElementRep> titles) {
		this.titles = titles;
	}

	public List<CategoryRep> getCs() {
		return cs;
	}

	public void setCs(List<CategoryRep> cs) {
		this.cs = cs;
	}

}
