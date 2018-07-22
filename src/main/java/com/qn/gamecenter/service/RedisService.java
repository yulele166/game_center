package com.qn.gamecenter.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.DateUtil;

/**
 * redis相关服务
 * 
 * @user 
 * @date 2016年6月1日
 */
@Service
public class RedisService {
	@Autowired
	private RedisTemplate<String, String> jedisTemplate;

	@Autowired
	private RedisTemplate<String, Object> jedisObjTemplate;
	@Autowired
	private RedisProxyService redisProxyService;

	public void setStringValue(final String key, final String value) {
		redisProxyService.excute(new RedisCallBack() {
			@Override
			public String excute() {
				ValueOperations<String, String> valueOps = jedisTemplate
						.opsForValue();
				boolean needExpire = false;
                if (!existKey(key)) {
                    needExpire = true;
                }
				valueOps.set(key, value);
				// 设置过期时间到当天晚上12点
				// 计算当前时间距离零点时间的小时数
				// jedisTemplate.expire(key, 1, TimeUnit.DAYS);
				if(needExpire){
				    jedisObjTemplate.expire(key,
	                        DateUtil.getNowRemainTomorrowSeconds(),
	                        TimeUnit.SECONDS);
				}
				return null;
			}
		});
	}

	public String getStringValue(final String key) {

		return (String) redisProxyService.excute(new RedisCallBack() {
			@Override
			public String excute() {
				ValueOperations<String, String> valueOps = jedisTemplate
						.opsForValue();
				return valueOps.get(key);
			}
		});
	}

	public void setObjValue(final String key, final Object value) {
		redisProxyService.excute(new RedisCallBack() {
			@Override
			public String excute() {
				ValueOperations<String, Object> valueOps = jedisObjTemplate
						.opsForValue();
				boolean needExpire = false;
                if (!existKey(key)) {
                    needExpire = true;
                }
				valueOps.set(key, value);
				// 设置过期时间到当天晚上12点
				// 计算当前时间距离零点时间的小时数
				// jedisObjTemplate.expire(key, 1, TimeUnit.DAYS);
				if(needExpire){
				    jedisObjTemplate.expire(key,
	                        DateUtil.getNowRemainTomorrowSeconds(),
	                        TimeUnit.SECONDS);
				}
				return null;
			}
		});
	}

	public Object getObjValue(final String key) {

		return redisProxyService.excute(new RedisCallBack() {
			@Override
			public Object excute() {
				ValueOperations<String, Object> valueOps = jedisObjTemplate
						.opsForValue();
				return valueOps.get(key);
			}
		});
	}

	/**
	 * 
	 * @param key
	 */
	public String popListObj(String key) {
		ListOperations<String, String> listOperations = jedisTemplate
				.opsForList();
		return listOperations.leftPop(key);
	}

	public void pushListObj(String key, String code) {
		ListOperations<String, String> listOperations = jedisTemplate
				.opsForList();
		listOperations.leftPush(key, code);
	}

	public void addHash(String hashKey, String imei, String code) {
		HashOperations<String, String, String> hashOpt = jedisTemplate
				.opsForHash();
		hashOpt.put(hashKey, imei, code);
	}

	public String getHashValue(String key, String hashKey) {
		HashOperations<String, String, String> hashOpt = jedisTemplate
				.opsForHash();
		return hashOpt.get(key, hashKey);
	}

	public Object getHashObjectValue(final String key, final String hashKey) {

		return redisProxyService.excute(new RedisCallBack() {
			@Override
			public Object excute() {
				HashOperations<String, String, Object> hashOpt = jedisObjTemplate
						.opsForHash();
				return hashOpt.get(key, hashKey);
			}
		});

	}

	public void addHashObjectValue(final String key, final String hashKey,
			final Object obj) {
		redisProxyService.excute(new RedisCallBack() {
			@Override
			public String excute() {

				if (!existKey(key)) {
					jedisObjTemplate.expire(key,
							DateUtil.getNowRemainTomorrowSeconds(),
							TimeUnit.SECONDS);
				}
				HashOperations<String, String, Object> hashOpt = jedisObjTemplate
						.opsForHash();
				hashOpt.put(key, hashKey, obj);
				return null;
			}
		});
	}

	public boolean existHashKey(String key, String hashKey) {
		HashOperations<String, String, String> hashOpt = jedisTemplate
				.opsForHash();
		return hashOpt.hasKey(key, hashKey);
	}

	/**
	 * 判断是否存在key
	 * 
	 * @param key
	 * @return
	 */
	public boolean existKey(String key) {
		return jedisTemplate.hasKey(key);
	}

	/**
	 * 次数＋1
	 * 
	 * @param hashKey
	 * @param key
	 */
	public void increHashValue(String key, String hashKey) {
		HashOperations<String, String, Object> hashOpt = jedisObjTemplate
				.opsForHash();
		hashOpt.increment(key, hashKey, 1);
	}

	/**
	 * 获取value 不受缓存开关控制
	 * 
	 * @param key
	 * @return
	 */
	public String getStringValueNoCache(String key) {
		ValueOperations<String, String> valueOps = jedisTemplate.opsForValue();
		return valueOps.get(key);
	}

}
