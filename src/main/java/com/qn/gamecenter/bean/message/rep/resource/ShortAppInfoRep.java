package com.qn.gamecenter.bean.message.rep.resource;

import java.util.List;

import com.qn.gamecenter.bean.OpenType;
import com.qn.gamecenter.bean.message.rep.AppContentRep;
import com.qn.gamecenter.bean.message.rep.CategoryRep;

/**
 * 软件信息简要信息，用户列表展示中
 * 
 * @user 
 * @date 2016年6月6日
 */
public class ShortAppInfoRep extends ElementRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3313987153014768253L;
	/** 软件id **/
	protected int appId;
	/** 类型集合 **/
	protected List<CategoryRep> categorys;

	protected String crc;

	protected String packageName;

	protected String version;

	protected String versionName;

	protected int size;

	protected String tag;

	protected String downloadUrl;

	protected List<AppContentRep> contents;

	protected List<? extends ElementRep> eles;

	protected int giftNum;

	protected int imgType;// 标签类型

	protected String word;// 标签名字

	protected int animationType;// 动画类型

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public int getGiftNum() {
		return giftNum;
	}

	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}

	public List<? extends ElementRep> getEles() {
		return eles;
	}

	public void setEles(List<? extends ElementRep> eles) {
		this.eles = eles;
	}

	public List<AppContentRep> getContents() {
		return contents;
	}

	public void setContents(List<AppContentRep> contents) {
		this.contents = contents;
	}

	public String getDownloadUrl() {
		return downloadUrl;
	}

	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
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

	public List<CategoryRep> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<CategoryRep> categorys) {
		this.categorys = categorys;
	}

	public ShortAppInfoRep() {
		this.openType = OpenType.OPEN_APP_INFO_PAGE;
	}

	public int getImgType() {
		return imgType;
	}

	public void setImgType(int imgType) {
		this.imgType = imgType;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getAnimationType() {
		return animationType;
	}

	public void setAnimationType(int animationType) {
		this.animationType = animationType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShortAppInfoRep other = (ShortAppInfoRep) obj;
		if (appId != other.appId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShortAppInfoRep [appId=" + appId + ", categorys=" + categorys
				+ ", crc=" + crc + ", packageName=" + packageName
				+ ", version=" + version + ", versionName=" + versionName
				+ ", size=" + size + ", tag=" + tag + ", downloadUrl="
				+ downloadUrl + ", contents=" + contents + ", eles=" + eles
				+ ", giftNum=" + giftNum + ", imgType=" + imgType + ", word="
				+ word + ", animationType=" + animationType + "]";
	}
	
	

}
