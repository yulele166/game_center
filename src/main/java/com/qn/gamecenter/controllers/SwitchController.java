/**
 * 
 */
package com.qn.gamecenter.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.SwitchListRep;
import com.qn.gamecenter.service.SwitchService;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * @author yulele
 * @time 2017年9月8日 下午3:26:01
 * 
 */
@Path("/switch/")
public class SwitchController {

	@Autowired
	private SwitchService switchService;
	/**
	 * 获取所有开关
	 * @return
	 */
	@Get("/getSwitchs")
	public SwitchListRep getSwitchs(){
		return switchService.getSwitchs();
	}
}
