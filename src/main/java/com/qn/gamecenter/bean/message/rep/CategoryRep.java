package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.OpenType;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;

/**
 * 获取分类信息
 * 
 * @user 
 * @date 2016年6月1日
 */
public class CategoryRep extends ElementRep {
	private int id;
	private String name;
	private String imgUrl;
	private int color;
	private List<CategoryRep> cs;

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CategoryRep> getCs() {
		return cs;
	}

	public void setCs(List<CategoryRep> cs) {
		this.cs = cs;
	}

	public CategoryRep() {
		this.openType = OpenType.OPEN_CATEGORY_PAGE;
	}
}
