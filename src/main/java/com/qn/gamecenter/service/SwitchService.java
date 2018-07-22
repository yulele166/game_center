/**
 * 
 */
package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.message.rep.SwitchListRep;
import com.qn.gamecenter.bean.message.rep.resource.SwitchRep;
import com.qn.gamecenter.dao.SwitchDAO;

/**
 * 开关服务
 * @author yulele
 * @time 2017年9月8日 下午3:53:00
 * 
 */
@Service
public class SwitchService {
	
	@Autowired
	private SwitchDAO switchDAO;
	@Autowired
	private RedisService redisService;

	/**
	 * 获取所有开关
	 * @return
	 */
	public SwitchListRep getSwitchs() {
		Object obj = redisService.getObjValue(RedisKey.SWITCH_LIST);
		if (obj != null) {
			return (SwitchListRep) obj;
		}
	
		//获取所有开关信息
		List<SwitchRep> switchs = switchDAO.getSwitchs();
		
		SwitchListRep rep = new SwitchListRep();
		rep.setSwitchs(switchs);
		
		redisService.setObjValue(RedisKey.SWITCH_LIST, rep);
		return rep;
	}

}
