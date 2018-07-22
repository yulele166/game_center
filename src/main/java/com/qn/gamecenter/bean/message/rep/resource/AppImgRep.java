package com.qn.gamecenter.bean.message.rep.resource;


/**
 * @user 
 * @date 2016年6月20日
 */
public class AppImgRep extends ElementRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7945123225290886525L;
	private String bigImgUrl;
	
	public String getBigImgUrl() {
		return bigImgUrl;
	}
	public void setBigImgUrl(String bigImgUrl) {
		this.bigImgUrl = bigImgUrl;
	}
	public AppImgRep() {
	}
	public AppImgRep(int showType){
		this.showType = showType;
	}
	
}
