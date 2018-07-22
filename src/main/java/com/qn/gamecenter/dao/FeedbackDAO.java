package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 反馈信息
 * 
 * @user 
 * @date 2016年8月2日
 */
@DAO
public interface FeedbackDAO {

	@SQL("insert into game_center_feedback(content,contact,imei) values(:1,:2,:3)")
	public void addFeedback(String content, String contact, String imei);

}
