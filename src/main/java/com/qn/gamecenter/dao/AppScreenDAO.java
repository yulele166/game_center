package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.db.Screen;

/**
 * @user 
 * @date 2016年6月30日
 */
@DAO
public interface AppScreenDAO {
	@SQL("select imgUrl,openType,elementId from game_center_screen where :1 between startTime and endTime")
	public Screen getScreen(String date);
}
