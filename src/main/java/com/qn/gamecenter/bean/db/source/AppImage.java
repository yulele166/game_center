package com.qn.gamecenter.bean.db.source;
/**
 * 软件详情页种的图片
 * @user 
 * @date 2016年6月15日
 */
public class AppImage {
	private int id;
	private int appId;//软件id
	private String imgUrl;//图片地址
	private String smallImgUrl;//小尺寸图片地址
	private int state;//是否使用
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getSmallImgUrl() {
		return smallImgUrl;
	}
	public void setSmallImgUrl(String smallImgUrl) {
		this.smallImgUrl = smallImgUrl;
	}
	
}
