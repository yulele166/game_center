package com.qn.gamecenter.bean.db;
/**
 * 分类
 * @user 
 * @date 2016年6月1日
 */
public class Category {
	private int id;//
	private int name;//分类名称
	private int parentId;//父id
	private String imgUrl;//图片地址
	
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
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
}
