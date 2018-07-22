/**
 * 
 */
package com.qn.gamecenter.dao;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.SwitchRep;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @author yulele
 * @time 2017年9月8日 下午3:58:26
 * 
 */
@DAO
public interface SwitchDAO {

	@SQL("select switchId,isValid from game_center_switch")
	public List<SwitchRep> getSwitchs();

}
