package com.qn.gamecenter.dao;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.HotWord;

import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年6月26日
 */
@DAO
public interface HotWordDAO {
	@SQL("select id,name,color,imgUrl from game_center_hot_word where id = :1")
	public HotWord getHotWord(int id);

	/**
	 * 获取热词相关联的appid
	 * 
	 * @param id
	 * @return
	 */
	@SQL("select appId from game_center_hot_word_app where hotWordId = :1")
	public List<Integer> getHotWordAppIds(int id);

	/**
	 * 获取热词相关联的appid
	 * 
	 * @param word
	 * @return
	 */
	@SQL("select appId from game_center_hot_word_app where hotWord = :1 order by sort")
	public List<Integer> getHotWordAppIds(String word);

    @SQL("select tagWord as word,imgType,animationType from game_center_hot_word_app where hotWord=:1 and appId=:2")
    ShortAppInfoRep getHotWord(String word, int appId);

}
