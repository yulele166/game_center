package com.qn.gamecenter.bean.db.source;
/**
 * 软件信息
 * @user
 * @date 2016年6月1日
 */
public class AppInfo {
	/** 软件id **/
	private int appId;
	/** 软件名称 **/
	private String appName;
	/** 软件描述 **/
	private String detailDesc;
	/** 开发者 **/
	private String author;
	/** 创建者id **/
	private int creatorId;
	/** 最后一次更新时间 **/
	private Object lastUpdateTime;
	/** 状态 **/
	private int state;
	/** 星数 **/
	private int praise;
	/** 总下载 **/
	private int totalDownload;
	/** 简介 **/
	private String shortDesc;
	/**  **/
	private String apprelation;
	/** 价格 **/
	private String cost;
	/** 图标 **/
	private String icon;
	/** 分类 **/
	private int classId;
	/** 来源类型 **/
	private int resourcetype;
	/** 包名 **/
	private String packageName;
	/** 创建时间 **/
	private Object createDate;
	/** 最后修改者id **/
	private int editor;
	/**  **/
	private String sigmd5;
	/** 标签 **/
	private String tag;
	/** 语言 **/
	private String language;
	/** 活跃版本 **/
	private String activeVersion;
	/** 活跃版本的大小 **/
	private String activeVersionSize;
	/** 下载进度条 **/
	private int download;
	/** 新热进度条 **/
	private int newHot;
	/** 品质 **/
	private int quality;
	/** 返利 **/
	private int profit;
	/** 客户电话 **/
	private String phoneNum;
	
	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getAppId() {
		return appId;
	}

	public void setAppId(int appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public Object getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Object lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public int getTotalDownload() {
		return totalDownload;
	}

	public void setTotalDownload(int totalDownload) {
		this.totalDownload = totalDownload;
	}

	public String getShortDesc() {
		return shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Object getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Object createDate) {
		this.createDate = createDate;
	}

	public int getDownload() {
		return download;
	}

	public void setDownload(int download) {
		this.download = download;
	}

	public int getNewHot() {
		return newHot;
	}

	public void setNewHot(int newHot) {
		this.newHot = newHot;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getProfit() {
		return profit;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getActiveVersion() {
		return activeVersion;
	}

	public void setActiveVersion(String activeVersion) {
		this.activeVersion = activeVersion;
	}

	public String getActiveVersionSize() {
		return activeVersionSize;
	}

	public void setActiveVersionSize(String activeVersionSize) {
		this.activeVersionSize = activeVersionSize;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getPraise() {
		return praise;
	}

	public void setPraise(int praise) {
		this.praise = praise;
	}


	public String getApprelation() {
		return apprelation;
	}

	public void setApprelation(String apprelation) {
		this.apprelation = apprelation;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}


	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}


	public int getResourcetype() {
		return resourcetype;
	}

	public void setResourcetype(int resourcetype) {
		this.resourcetype = resourcetype;
	}

	public int getEditor() {
		return editor;
	}

	public void setEditor(int editor) {
		this.editor = editor;
	}


	public String getSigmd5() {
		return sigmd5;
	}

	public void setSigmd5(String sigmd5) {
		this.sigmd5 = sigmd5;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

}
