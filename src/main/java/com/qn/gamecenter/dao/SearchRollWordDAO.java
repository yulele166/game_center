package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年6月29日
 */
@DAO
public interface SearchRollWordDAO {
	@SQL("select word from game_center_roll_word ")
	public List<String> getWords();
}
