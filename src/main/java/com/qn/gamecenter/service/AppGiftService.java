package com.qn.gamecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.dao.GiftDAO;

/**
 * 礼包相关服务类
 * 
 * @user 
 * @date 2016年7月1日
 */
@Service
public class AppGiftService {
	@Autowired
	private GiftDAO giftDAO;

	/**
	 * 获取礼包数量
	 * 
	 * @param appId
	 * @return
	 */
	public int getGiftNum(int appId) {
		return giftDAO.getGiftNum(appId);
	}


}
