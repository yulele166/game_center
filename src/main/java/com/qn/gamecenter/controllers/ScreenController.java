package com.qn.gamecenter.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.service.ScreenService;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

/**
 * @user 
 * @date 2016年6月30日
 */
@Path("/screen")
public class ScreenController {
	@Autowired
	private ScreenService service;
	
	@Get("/getFirstScreen")
	public ElementRep getFirstScreen() {
		return service.getFirstScreen();
	}
}
