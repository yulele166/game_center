package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年7月7日
 */
@DAO
public interface SubjectBrowTimeDAO {
	@SQL("select num from game_center_brow_time where subjectId = :1")
	public Integer getTimes(int subjectId);

	@SQL("insert into game_center_brow_time(subjectId,num) values(:1,1) on duplicate key  update  num=num+1 ")
	public void addTimes(int subjectId);
}
