package com.qn.gamecenter.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.RequestMessage;
import com.qn.gamecenter.bean.message.req.BaseInfoReq;
import com.qn.gamecenter.bean.message.req.GetGiftReq;

/**
 * 用户相关服务
 * 
 * @user 
 * @date 2016年9月7日
 */
@Service
public class UserService {

	@Autowired
	private RedisService redisService;

	@Autowired
	private RedisKeyService redisKeyService;
	
	@Autowired
	private CodeService codeService;

	private Logger LOG = LoggerFactory.getLogger(UserService.class);

	/**
	 * 添加活跃用户
	 * 
	 * @param BaseInfoReq
	 */
	public void addActUser(BaseInfoReq baseInfo, String method) {
		if (baseInfo == null) {
			return;
		}
		if (isAct(method, baseInfo)) {
			int dateStr = DateUtil.getTodayDate();
			redisService.addHashObjectValue(RedisKey.DAY_ACTIVITY_USER
					+ dateStr, baseInfo.getImei(),
					JSONObject.toJSONString(baseInfo));
		}
	}

	/**
	 * 判断请求是否属于用户活跃产生的
	 * <p>
	 * 第三方软件更新与自身更新不需要启动应用，不记为活跃
	 * </p>
	 * 
	 * @param method
	 *            请求方法名
	 * @return
	 */
	public boolean isAct(String method, BaseInfoReq baseInfo) {
		if (StringUtils.isBlank(method)) {
			return false;
		}
		// 第三方软件更新
		if ("updateapps".equals(method)) {
			return false;
		}
		// 自身软件更新
		if ("getpkg".equals(method)) {
			return false;
		}
		// 判断是否访问过起屏页面和精品页面
		if (!isRealUser(baseInfo.getImei())) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否有正常行为的用户
	 * 
	 * @param method
	 * @param baseInfo
	 * @return
	 */
	public boolean isRealUser(String imei) {
//		String updateAppKey = redisKeyService.getUpdateAppKey(DateUtil
//				.getTodayDate() + "");
//		String yesAppKey = redisKeyService.getUpdateAppKey(getDateStr(DateUtil
//				.getYestrdayStr()));
		String qualityKey = redisKeyService.getQualityPageScreenKey();
		boolean hasQuality = redisService.existHashKey(qualityKey, imei);
		//是否访问过精品页面
		if (!hasQuality) {
			return false;
		}
		//在两天内是否有访问过自身更新接口
//		boolean todayUpdate = redisService.existHashKey(updateAppKey, imei);
//		boolean yesUpdate = redisService.existHashKey(yesAppKey, imei);
//		if(!todayUpdate && !yesUpdate){
//			return false;
//		}
		return true;
	}

	/**
	 * 记录用户 行为
	 * 
	 * @param method
	 * @return
	 */
	public void addUserActive(String method, RequestMessage req,
			BaseInfoReq baseInfo) {
		if (baseInfo != null) {
			String key = getRedisKey(method, req);
			if (StringUtils.isNotBlank(key)
					&& StringUtils.isNotBlank(baseInfo.getUid())) {
				redisService.addHashObjectValue(key, baseInfo.getImei(),
						baseInfo);
			}
		}
	}

	/**
	 * 是否有获取礼包列表的行为
	 * 
	 * @param imei
	 * @param appId
	 * @return
	 */
	public boolean hasGiftsListAct(String imei, int appId) {
		String key = redisKeyService.getGiftListKey(appId);
		if (!redisService.existHashKey(key, imei)) {
			return false;
		}
		return true;
	}

	/**
	 * 获取对应行为的redis key
	 * 
	 * @param method
	 * @param params
	 * @return
	 */
	public String getRedisKey(String method, RequestMessage params) {
		LOG.info("method name is : {}", method);
		if ("getqualitypage".equals(method)) {
			return redisKeyService.getQualityPageScreenKey();
		}
//		if ("getgifts".equals(method)) {
//			GetGiftReq giftReq = (GetGiftReq) params;
//			return redisKeyService.getGiftListKey(giftReq.getAppId());
//		}
		if ("getpkg".equals(method)) {
			return redisKeyService
					.getUpdateAppKey(DateUtil.getTodayDate() + "");
		}
		return "";
	}

	/**
	 * 用户是否可以领取礼包 依据是否有用户的正常行为
	 * 
	 * @param imei
	 * @return
	 */
	public boolean canGetGift(String imei, int appId,String uid) {
		if (!isRealUser(imei)) {
			return false;
		}
//		if (!hasGiftsListAct(imei, appId)) {
//			return false;
//		}
		String decodeImei = codeService.getUid(uid, "1111111111111");
		
		if(!decodeImei.contains(imei)){
			return false;
		}
		return true;
	}

	public static String getDateStr(String date) {
		try {
			return date.trim().replace("-", "");
		} catch (Exception e) {
			return "";
		}
	}

	public static void main(String[] args) {
	}
}
