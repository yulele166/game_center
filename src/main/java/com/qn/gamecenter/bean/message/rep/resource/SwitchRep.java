/**
 * 
 */
package com.qn.gamecenter.bean.message.rep.resource;

import java.io.Serializable;

/**
 * 开关
 * @author yulele
 * @time 2017年9月8日 下午3:37:30
 * 
 */
public class SwitchRep implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1725873082566446128L;
	private int switchId; //开关id
	//private String switchName; //开关名
	private int isValid; //是否开启生效
	
	public int getSwitchId() {
		return switchId;
	}
	public void setSwitchId(int switchId) {
		this.switchId = switchId;
	}
	
	public int getIsValid() {
		return isValid;
	}
	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}
	

	
	

}
