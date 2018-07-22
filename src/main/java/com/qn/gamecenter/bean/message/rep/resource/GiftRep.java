package com.qn.gamecenter.bean.message.rep.resource;

/**
 * 礼包
 * 
 * @user 
 * @date 2016年6月13日
 */
public class GiftRep extends ElementRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8296675716074516021L;
	/** 过期时间 **/
	protected String expireDate;// 过期时间
	/** 软件id **/
	protected int appId;// 所属app
	/** 总天数 **/
	protected String totalDate;// 总天数
	/** 礼包状态 （1 领取，2 过期，0 未领取） **/
	protected int state;
	/** 礼包数量 **/
	protected int num;
	/** 软件包名 **/
	protected String packageName;
	/** 软件图标 */
	protected String icon;
	/** 过期时间戳 **/
	protected long expireTimes;

	
	
	
	public long getExpireTimes() {
		return expireTimes;
	}

	public void setExpireTimes(long expireTimes) {
		this.expireTimes = expireTimes;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTotalDate() {
		return totalDate;
	}

	public void setTotalDate(String totalDate) {
		this.totalDate = totalDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

}
