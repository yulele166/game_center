package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.db.DbShowType;

/**
 * @user 
 * @date 2016年7月10日
 */
@DAO
public interface ShowTypeDAO {
	@SQL("select showTypeId,needShow from game_center_show_type")
	public List<DbShowType> getShowTypes();
}
