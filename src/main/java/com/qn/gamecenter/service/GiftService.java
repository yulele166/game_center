package com.qn.gamecenter.service;

import java.util.List;

import net.paoding.rose.web.Invocation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.ErrorCodeConstant;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.message.rep.AppGiftRep;
import com.qn.gamecenter.bean.message.rep.GiftWithNumRep;
import com.qn.gamecenter.bean.message.rep.ReceiveGiftRep;
import com.qn.gamecenter.bean.message.rep.resource.GiftRep;
import com.qn.gamecenter.bean.message.req.BaseInfoReq;
import com.qn.gamecenter.dao.GiftDAO;

/**
 * 礼包相关服务
 * 
 * @user 
 * @date 2016年6月15日
 */
@Service
public class GiftService {

	@Autowired
	private GiftDAO giftDAO;

	@Autowired
	private RedisService redisService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CodeService codeService;

	/**
	 * 获取礼包列表
	 * 
	 * @param appId
	 * @return
	 */
	public AppGiftRep getGifts(int appId) {
		AppGiftRep rep = new AppGiftRep();
		List<GiftRep> gifts = giftDAO.getGifts(appId);
		rep.setGifts(gifts);
		return rep;
	}

	public List<GiftRep> getGiftList(int appId) {
		return giftDAO.getGifts(appId);
	}

	/**
	 * 获取一个礼包
	 * 
	 * @param appId
	 * @return
	 */
	public GiftWithNumRep getGift(int appId) {
		return null;
	}

	/**
	 * 获取礼包数量
	 * 
	 * @param appId
	 * @return
	 */
	public int getGiftNum(int appId) {
		return giftDAO.getGiftNum(appId);
	}

	/**
	 * 领取礼包
	 * 
	 * @param giftId
	 * @return
	 */
	public ReceiveGiftRep receiveGift(int giftId, BaseInfoReq baseInfoReq,
			Invocation inv) {
		ReceiveGiftRep rep = new ReceiveGiftRep();
		String imei = baseInfoReq.getImei();
		String code;
		GiftRep gift = isExpireDate(giftId);
		int appId = giftDAO.getAppIdByGiftId(giftId);
		boolean canReceive = userService.canGetGift(imei, appId,baseInfoReq.getUid());
		if (gift != null) {
			if (canReceive) {
				// 检测是否已经领取过礼包
				if (!hasReceive(giftId, imei)) {
					code = redisService.popListObj(RedisKey.GIFT_CODE_PRE
							+ giftId);
					if (gift.getNum() > 0) {
						giftDAO.changeNum(giftId);
					}
					if (StringUtils.isNotBlank(code)) {
						redisService.addHash(
								RedisKey.HAS_RECEIVE_GIFT + giftId, imei, code);
						giftDAO.giftReceiveLog(giftId, code, imei);
					} else {
						messageService.getRepMessage(inv).setStatus(
								ErrorCodeConstant.GIFT_NULL);
					}
				} else {
					code = redisService.getHashValue(RedisKey.HAS_RECEIVE_GIFT
							+ giftId, imei);
				}
				rep.setGiftCode(code);
				// 获取软件图标
				rep.setImgUrl(gift.getIcon());
			}else{
				//这里认为此领取礼包的请求为恶意请求 随机一个礼包码返回
				rep.setGiftCode(getRandomGiftGode());
				rep.setImgUrl(gift.getIcon());
			}
		}
		return rep;
	}

	/**
	 * 判断是否领取过礼包
	 * 
	 * @param giftId
	 * @param imei
	 * @return
	 */
	public boolean hasReceive(int giftId, String imei) {
		// 判断是否领取过该礼包
		boolean hasRec = redisService.existHashKey(RedisKey.HAS_RECEIVE_GIFT
				+ giftId, imei);
		return hasRec;
	}

	/**
	 * 是否已经过期
	 * 
	 * @param giftId
	 * @return
	 */
	public GiftRep isExpireDate(int giftId) {
		GiftRep giftRep = giftDAO.getGiftById(giftId);
		if (System.currentTimeMillis() < giftRep.getExpireTimes()) {
			return giftRep;
		}
		return null;
	}
	/**
	 * 获取 随机礼包码
	 * @return
	 */
	public String getRandomGiftGode(){
		return codeService.getRandomStr();
	}
	
	

}
