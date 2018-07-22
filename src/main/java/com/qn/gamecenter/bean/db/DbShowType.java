package com.qn.gamecenter.bean.db;

/**
 * 对应数据库中的 game_center_show_type表
 * 
 * @user
 * @date 2016年7月10日
 */
public class DbShowType {
	private int showTypeId;
	private String typeDesc;
	private int flag;
	private int needShow;

	public int getShowTypeId() {
		return showTypeId;
	}

	public void setShowTypeId(int showTypeId) {
		this.showTypeId = showTypeId;
	}

	public String getTypeDesc() {
		return typeDesc;
	}

	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getNeedShow() {
		return needShow;
	}

	public void setNeedShow(int needShow) {
		this.needShow = needShow;
	}

}
