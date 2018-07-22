/**
 * 
 */
package com.qn.gamecenter.bean.message.rep;

import java.io.Serializable;
import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.SwitchRep;

/**
 * @author yulele
 * @time 2017年9月8日 下午3:35:16
 * 
 */
public class SwitchListRep implements Serializable{

	

	private List<SwitchRep> switchs;

	public void setSwitchs(List<SwitchRep> switchs) {
		this.switchs = switchs;
	}

	public List<SwitchRep> getSwitchs() {
		return switchs;
	}
	
	
	

}
