package com.qn.gamecenter.bean.message.rep.resource;

import com.qn.gamecenter.bean.OpenType;

/**
 * 分类信息
 * 
 * @user 
 * @date 2016年6月12日
 */
public class CategoryRep extends ElementRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8275859578850140002L;
	private int cid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public CategoryRep() {
		this.openType = OpenType.OPEN_CATEGORY_PAGE;
	}

}
