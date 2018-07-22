package com.qn.gamecenter.bean.message.rep;

import java.io.Serializable;

import com.qn.gamecenter.bean.ResponseMessage;

/**
 * @user 
 * @date 2016年6月27日
 */

public class AppContentRep extends ResponseMessage implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8425732757977063242L;
	private int num;//数量
	private String name;//名字
	private int type;
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public AppContentRep(int num, String name, int type) {
		super();
		this.num = num;
		this.name = name;
		this.type = type;
	}
	public AppContentRep() {
		super();
	}
	
	
}
