package com.qn.gamecenter.bean.db;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应数据库中的gaem_center_packge
 * 
 * @author 
 * @since 2015年12月1日 下午2:54:32
 */
public class DbPackage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8009247373515627142L;
	private int id;// 唯一id标识
	private int version;// 版本号
	private String channel;// 渠道标识
	private String address;// 安装包下载地址
	private String sign;// 签名
	private Date createTime;// 安装包发布时间
	private String descs;// 描述
	private String md5;// md5值
	private String versionName;// 版本号字符串
	private String crc;//crc32
	private String packageName;//包名
	private int versionSize;//大小
	private String imgUrl;
	private String name;
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVersionSize() {
		return versionSize;
	}

	public void setVersionSize(int versionSize) {
		this.versionSize = versionSize;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getCrc() {
		return crc;
	}

	public void setCrc(String crc) {
		this.crc = crc;
	}

	public String getVersionName() {
		return versionName;
	}

	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}

	public String getMd5() {
		return md5;
	}

	public void setMd5(String md5) {
		this.md5 = md5;
	}


	public String getDescs() {
		return descs;
	}

	public void setDescs(String descs) {
		this.descs = descs;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "DbPackage [id=" + id + ", version=" + version + ", channel="
				+ channel + ", address=" + address + ", sign=" + sign
				+ ", createTime=" + createTime + "]";
	}

}
