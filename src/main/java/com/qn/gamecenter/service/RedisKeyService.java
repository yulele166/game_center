package com.qn.gamecenter.service;

import org.springframework.stereotype.Service;

import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.RedisKey;

/**
 * @user 
 * @date 2016年9月13日
 */
@Service
public class RedisKeyService {

	/**
	 * 分类信息优先软件的key
	 * 
	 * @param cId
	 * @return
	 */
	public String getCategoryAppKey(String cId) {
		return RedisKey.CATEGORY_APP + cId;
	}

	/**
	 * 分类软件的分页缓存key
	 * 
	 * @param cId
	 * @return
	 */
	public String getCategorySharePageKey(String cId) {
		return RedisKey.CATEGORY_SHARE_PAGE + cId;
	}

	/**
	 * 获取访问过起屏页面的imei,key
	 * 
	 * @return
	 */
	public String getFirstScreenKey() {
		return RedisKey.GET_FIRST_SCREEN + DateUtil.getTodayDate();
	}

	/**
	 * 获取访问过精品页面的imei ，key
	 * 
	 * @return
	 */
	public String getQualityPageScreenKey() {
		return RedisKey.GET_QUALITY_PAGE + DateUtil.getTodayDate();
	}

	/**
	 * 获取获取过礼包列表页面的imei ，key
	 * 
	 * @return
	 */
	public String getGiftListKey(int appId) {
		return RedisKey.GET_GIFT_REQUEST  + appId
				+ DateUtil.getTodayDate();
	}

	/**
	 * 获取三天内访问过更新接口的用户key
	 * 
	 * @return
	 */
	public String getUpdateAppKey(String date) {
		return RedisKey.UPDATE_APP_INFO + ":" + date;
	}

}
