package com.qn.gamecenter.bean.db;

/**
 * 专题与元素的关联表
 * 
 * @user
 * @date 2016年6月14日
 */
public class SubjectElement {
	private int subjectId;
	private int elementId;
	private int showType;
	private int openType;
	private int sort;
	private int imgType;
	private int animationType;
	private String tagWord;
	private String showDesc;//用于展示的文本
	

	public String getShowDesc() {
		return showDesc;
	}

	public void setShowDesc(String showDesc) {
		this.showDesc = showDesc;
	}

	public int getImgType() {
		return imgType;
	}

	public void setImgType(int imgType) {
		this.imgType = imgType;
	}

	public int getAnimationType() {
		return animationType;
	}

	public void setAnimationType(int animationType) {
		this.animationType = animationType;
	}

	public String getTagWord() {
		return tagWord;
	}

	public void setTagWord(String tagWord) {
		this.tagWord = tagWord;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public int getElementId() {
		return elementId;
	}

	public void setElementId(int elementId) {
		this.elementId = elementId;
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

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

}
