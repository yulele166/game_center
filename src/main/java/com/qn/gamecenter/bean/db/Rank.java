package com.qn.gamecenter.bean.db;

/**
 * @user 
 * @date 2016年6月24日
 */
public class Rank {
	private int id;
	private int rank;
	private int appId;
	private int type;
	private String tagWord;
	private int imgType;
	private int animationType;

	public String getTagWord() {
		return tagWord;
	}

	public void setTagWord(String tagWord) {
		this.tagWord = tagWord;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
