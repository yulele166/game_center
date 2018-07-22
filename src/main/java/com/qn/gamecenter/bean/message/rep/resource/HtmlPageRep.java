package com.qn.gamecenter.bean.message.rep.resource;

import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.OpenType;

/**
 * html页面
 * @user 
 * @date 2016年6月13日
 */
public class HtmlPageRep extends ElementRep{
	/** 所属应用id  **/
	protected int appId;
	/** 额外参数 **/
	protected String param;
	/** 创建时间 **/
	protected String createTime;
	/** 页面类型 1 活动 2 攻略 3 视频**/
	protected int type;
	/** 页面地址 */
	protected String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getAppId() {
		return appId;
	}
	public void setAppId(int appId) {
		this.appId = appId;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public HtmlPageRep() {
		this.openType = OpenType.OPEN_HTML_PAGE;
	}
	
}
