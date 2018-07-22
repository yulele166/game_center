package com.qn.gamecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.ServerConfig;

/**
 * @user 
 * @date 2016年7月14日
 */
@Service
public class RedisProxyService {
	@Autowired
	private ServerConfig serverConfig;

	/**
	 * 
	 * @param redisCallBack
	 * @return
	 */
	public Object excute(RedisCallBack redisCallBack) {
		Object obj = null;
		// 检查是否开启了缓存
		if (serverConfig.isCacheOpen()) {
			try {
				obj = redisCallBack.excute();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}
}
