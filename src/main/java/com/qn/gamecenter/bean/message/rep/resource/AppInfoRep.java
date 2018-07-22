package com.qn.gamecenter.bean.message.rep.resource;
/**
 * app详情
 * @user 
 * @date 2016年6月16日
 */
public class AppInfoRep extends ElementRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8083486732255453280L;
	/** 软件id **/
	private int appId;
	/** 软件名称 **/
	private String appName;
	/** 软件描述 **/
	private String detailDesc;
	/** 开发者 **/
	private String author;
	/** 状态 **/
	private int state;
	/** 星数 **/
	private int praise;
	/** 总下载 **/
	private int totalDownload;
	/** 图标 **/
	private String icon;
	/** 分类 **/
	private int classId;
	/** 包名 **/
	private String packageName;
	/** 创建时间 **/
	private Object createDate;
	/** 标签 **/
	private String tag;
	/** 语言 **/
	private String language;
	/** 活跃版本 **/
	private String version;
	/** 活跃版本的大小 **/
	private String size;
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
	/** **/
	private String crc;
	/** 下载地址 **/
	private String downloadUrl;
	
	private String starNum;
	
	private int starUserNum;
	
	private String creator;
	
	private String safeTag;
	
	private String className;
	
	private int isDef;
	
	private String versionName;
	
	private int hasGift;//配合客户端  是否有礼包页面

	private int hasHtml;//同上 是否有html页面
	
	public int getHasGift() {
		return hasGift;
	}
	public void setHasGift(int hasGift) {
		this.hasGift = hasGift;
	}
	public int getHasHtml() {
		return hasHtml;
	}
	public void setHasHtml(int hasHtml) {
		this.hasHtml = hasHtml;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public int getIsDef() {
		return isDef;
	}
	public void setIsDef(int isDef) {
		this.isDef = isDef;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getSafeTag() {
		return safeTag;
	}
	public void setSafeTag(String safeTag) {
		this.safeTag = safeTag;
	}
	
	
	public String getStarNum() {
		return starNum;
	}
	public void setStarNum(String starNum) {
		this.starNum = starNum;
	}
	public int getStarUserNum() {
		return starUserNum;
	}
	public void setStarUserNum(int starUserNum) {
		this.starUserNum = starUserNum;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDownloadUrl() {
		return downloadUrl;
	}
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}
	public String getCrc() {
		return crc;
	}
	public void setCrc(String crc) {
		this.crc = crc;
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
	public int getTotalDownload() {
		return totalDownload;
	}
	public void setTotalDownload(int totalDownload) {
		this.totalDownload = totalDownload;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
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
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
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
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	
}
