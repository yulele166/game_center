package com.qn.gamecenter.bean.message.rep.resource;

import java.io.Serializable;


/**
 * 客户端的展示元素
 * @user 
 * @date 2016年6月12日
 */
public class ElementRep implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 元素id **/
	protected int id;
	/** 展示类型 **/
	protected int showType;
	/** 打开类型 **/
	protected int openType;
	/** 元素名称 **/
	protected String name;
	/** 元素图片地址 **/
	protected String imgUrl;
	/** 简短介绍 **/
	protected String shortDesc;
	/** 详细描述 **/
	protected String detailDesc;
	/** 排序 **/
	protected int sort;
	
	
	
	
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	
	public String getDetailDesc() {
		return detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public int getShowType() {
		return showType;
	}
	public void setShowType(int showType) {
		this.showType = showType;
	}
	public int getOpenType() {
		return openType;
	}
	public void setOpenType(int openType) {
		this.openType = openType;
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
