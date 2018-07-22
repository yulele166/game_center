package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 精品页相关数据库操作
 * 
 * @user 
 * @date 2016年6月28日
 */
@DAO
public interface QualityPageDAO {
	@SQL("select subjectId from game_center_quality_page where :1 between startTime and endTime and type=:2")
	public Integer getSchedulePage(String date, int type);
}
