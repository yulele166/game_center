/**
 * 
 */
package com.qn.gamecenter.dao;

import com.qn.gamecenter.bean.db.TabPage;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @author yulele
 * @time 2016年10月29日 下午3:39:24
 * 
 */
@DAO
public interface TabPageDAO {
	
	final String TABLE = "game_center_tab";
	final String TABLE_FIELD = "imgUrl,startTime,endTime,openType,elementId,name";
	
	@SQL("select $TABLE_FIELD from $TABLE where now() between startTime and endTime")
	public TabPage getTabPageSchedule();

}
