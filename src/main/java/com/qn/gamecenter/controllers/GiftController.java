package com.qn.gamecenter.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppGiftRep;
import com.qn.gamecenter.bean.message.rep.ReceiveGiftRep;
import com.qn.gamecenter.bean.message.req.GetGiftReq;
import com.qn.gamecenter.bean.message.req.ReceiveGiftReq;
import com.qn.gamecenter.service.GiftService;

/**
 * 礼包相关接口
 * 
 * @user 
 * @date 2016年6月15日
 */
@Path("/gift/")
public class GiftController {
	@Autowired
	private GiftService giftService;

	/**
	 * 获取礼包列表
	 * 
	 * @param appId
	 * @return {@link AppGiftRep}
	 */
	@Get("/getGifts")
	public AppGiftRep getGifts(GetGiftReq req) {
		return giftService.getGifts(req.getAppId());
	}

	/**
	 * 领取礼包
	 */
	@Get("/receiveGift")
	public ReceiveGiftRep getGift(ReceiveGiftReq req,Invocation inv) {
		return giftService.receiveGift(req.getGiftId(),req.getBaseInfo(),inv);
	}

}
