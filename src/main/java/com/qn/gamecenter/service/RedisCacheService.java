package com.qn.gamecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.message.rep.resource.SubJect;

/**
 * 所有需要组合的key 的方法
 * 
 * @user 
 * @date 2016年7月14日
 */
@Service
public class RedisCacheService {

	@Autowired
	private RedisService redisService;

	private void setSubjectObj(SubJect sub, String key) {
		redisService.setObjValue(key, sub);
	}

	/**
	 * 获取专题中的缓存信息
	 * 
	 * @param key
	 * @param id
	 * @param pi
	 * @return
	 */
	public SubJect getSubject(int id, int pi) {
		String value = getSubjectStr(id, pi);
		return JSON.parseObject(value, SubJect.class);
	}

	/**
	 * 缓存专题信息
	 * 
	 * @param subject
	 */
	public void setSubject(SubJect subject, int pi) {
		setSubjectObj(subject, RedisKey.SUBJECT_CONTENT_PRE + subject.getId()
				+ ":" + pi);
	}

	/**
	 * 获取缓存中专题的json串
	 * 
	 * @param id
	 * @param pi
	 * @return
	 */
	public String getSubjectStr(int id, int pi) {
		return redisService.getStringValue(RedisKey.SUBJECT_CONTENT_PRE + id
				+ ":" + pi);
	}

	/**
	 * 获取缓存中专题的bean
	 * 
	 * @param id
	 * @param pi
	 * @return
	 */
	public SubJect getSubjectBean(int id, int pi) {
		return (SubJect) redisService.getObjValue(RedisKey.SUBJECT_CONTENT_PRE
				+ id + ":" + pi);
	}

}
