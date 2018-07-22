package com.qn.gamecenter.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.ScheduleType;
import com.qn.gamecenter.bean.ServerConfig;
import com.qn.gamecenter.bean.db.TabPage;
import com.qn.gamecenter.dao.QualityPageDAO;
import com.qn.gamecenter.dao.TabPageDAO;

/**
 * 
 * 所有排期相关服务
 * 
 * @user 
 * @date 2016年7月6日
 */
@Service
public class ScheduleService {
	@Autowired
	private QualityPageDAO qualityPageDAO;
	@Autowired
	private TabPageDAO tabPageDAO;
	@Autowired
	private RedisService redisService;
	@Autowired
	private ServerConfig serverConfig;
	private int DEAULT_TIMES = 3;

	/**
	 * 获取精品页排期
	 * 
	 * @return
	 */
	public int getQualityId(int startTimes) {
		// 先看预览排期
		// 根据启动次数拉取排期
		if (startTimes < DEAULT_TIMES && startTimes > 0) {
			if (serverConfig.isFuture()) {
				int subId = getFutureSepreQualityId();
				if (subId > 0) {
					return subId;
				}
			}
			return getScheduleId(RedisKey.QUALITY_SEPRE_PAGE_ID,
					ScheduleType.QUALITY_PAGE_SEPRE);
		} else {
			// 预览排期开关
			if (serverConfig.isFuture()) {
				int subId = getFutureQualityId();
				if (subId > 0) {
					return subId;
				}
			}
			return getScheduleId(RedisKey.QUALITY_PAGE_ID,
					ScheduleType.QUALITY_PAGE);
		}
	}

	/**
	 * 获取发现页面的排期
	 * 
	 * @return
	 */
	public Integer getDiscoveryPageId(int appVersion) {
		Integer discoverySecondPageId = getDiscoverySecondPageId();
		if (appVersion >= Constant.CONFIRM_DISCOVERY_PAGE_APPVERSION
				&& discoverySecondPageId != null)
			return discoverySecondPageId;
		return getScheduleId(RedisKey.DISCOVERY_PAGE_ID,
				ScheduleType.DISCOVERY_PAGE);

	}

	/**
	 * 获取发现页面二中排期
	 * 
	 * @return
	 */
	public Integer getDiscoverySecondPageId() {
		return getScheduleId(RedisKey.DISCOVERY_SECOND_PAGE_ID,
				ScheduleType.DISCOVERY_SECOND_PAGE);
	}

	/**
	 * 搜索页面热词排期
	 * 
	 * @return
	 */
	public int getSearchPageId() {
		return getScheduleId(RedisKey.SEARCH_PAGE_ID, ScheduleType.SEARCH_PAGE);
	}

	/**
	 * 获取精品页上的头图
	 * 
	 * @return
	 */
	public int getQualityPageTitle(int startTimes) {
		// 先看预览排期
		// 根据启动次数拉取排期
		if (startTimes < DEAULT_TIMES && startTimes > 0) {
			if (serverConfig.isFuture()) {
				int subId = getFutureSepreQualityTitleId();
				if (subId > 0) {
					return subId;
				}
			}
			return getScheduleId(RedisKey.QUALITY_PAGE_SEPRE_TITLE_ID,
					ScheduleType.QUALITY_PAGE_SEPRE_TITLE);
		} else {
			// 预览排期开关
			if (serverConfig.isFuture()) {
				int subId = getFutureQualityTitleId();
				if (subId > 0) {
					return subId;
				}
			}
			return getScheduleId(RedisKey.QUALITY_PAGE_TITLE_ID,
					ScheduleType.QUALITY_PAGE_TITLE);
		}

	}

	private Integer getScheduleId(String redisKey, int scheduleType) {
		Integer qualityId = null;
		// 取缓存
		String idStr = redisService.getStringValue(redisKey);
		if (StringUtils.isNotBlank(idStr)) {
			qualityId = Integer.parseInt(idStr);
		} else {
			String date = DateUtil.getTodayDateTimeStr();
			qualityId = qualityPageDAO.getSchedulePage(date, scheduleType);
			if (qualityId != null) {
				redisService.setStringValue(redisKey, qualityId + "");
			}
		}
		return qualityId;
	}

	/**
	 * 获取预览排期的id
	 * 
	 * @return
	 */
	private int getFutureQualityId() {
		int qualityId = 0;
		String idStr = redisService
				.getStringValueNoCache(RedisKey.QUALITY_PAGE_FUTURE);
		if (StringUtils.isNotBlank(idStr)) {
			qualityId = Integer.parseInt(idStr);
		}
		return qualityId;
	}

	/**
	 * 获取一套预览排期的id
	 * 
	 * @return
	 */
	private int getFutureSepreQualityId() {
		int qualityId = 0;
		String idStr = redisService
				.getStringValueNoCache(RedisKey.QUALITY_PAGE_SEPRE_FUTURE);
		if (StringUtils.isNotBlank(idStr)) {
			qualityId = Integer.parseInt(idStr);
		}
		return qualityId;
	}

	private int getFutureQualityTitleId() {
		int qualityId = 0;
		String idStr = redisService
				.getStringValueNoCache(RedisKey.QUALITY_PAGE_TITLE_FUTURE);
		if (StringUtils.isNotBlank(idStr)) {
			qualityId = Integer.parseInt(idStr);
		}
		return qualityId;
	}

	private int getFutureSepreQualityTitleId() {
		int qualityId = 0;
		String idStr = redisService
				.getStringValueNoCache(RedisKey.QUALITY_PAGE_TITLE_FUTURE_SEPRE);
		// =======
		// .getStringValueNoCache(RedisKey.QUALITY_PAGE_TITLE_FUTURE_SEPRE);
		// >>>>>>> .r10637
		if (StringUtils.isNotBlank(idStr)) {
			qualityId = Integer.parseInt(idStr);
		}
		return qualityId;
	}

	/**
	 * 获取当前tab页排期信息
	 * 
	 * @return
	 */
	public TabPage getTabPageSchedule() {
		Object obj = redisService.getObjValue(RedisKey.TAB_PAGE);
		if (obj != null) {
			return (TabPage) obj;
		} else {
			TabPage tab = tabPageDAO.getTabPageSchedule();
			if (tab != null) {
				redisService.setObjValue(RedisKey.TAB_PAGE, tab);
			}
			return tab;
		}

	}

}
