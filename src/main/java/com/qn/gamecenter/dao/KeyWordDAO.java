package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * 敏感词
 * 
 * @user 
 * @date 2016年8月2日
 */
@DAO
public interface KeyWordDAO {
	@SQL("select keyWord from game_center_key_word")
	public List<String> getWords();
}
