package com.qn.gamecenter.bean.message.req;

import java.io.Serializable;

/**
 * 所有请求都会携带的通用参数,用户基本信息
 * 
 * @author 
 * @since 2015年12月2日 下午4:25:59
 */
public class BaseInfoReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4992489087045194670L;
	/** 渠道 **/
	private String channel;
	/** imei **/
	private String imei;
	/** 软件版本 **/
	private String appVersion;
	/** 机型 **/
	private String model;
	/** 生成的用户uid */
	private String uid;
	/** 启动次数 **/
	private int startTimes;
	/** 厂商 **/
	private String brand;
	
	
	

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getStartTimes() {
		return startTimes;
	}

	public void setStartTimes(int startTimes) {
		this.startTimes = startTimes;
	}

	public int getVersionInt() {
		return Integer.parseInt(appVersion);
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
}
