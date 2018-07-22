package com.qn.gamecenter.dao;

import java.util.List;

import com.qn.gamecenter.bean.db.Rank;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年6月24日
 */
@DAO
public interface RankDAO {
	@SQL("select id,rank,appId,type,tagWord,imgType,animationType from game_center_rank where type = :1 order by rank limit :2,:3")
	public List<Rank> getRankByType(int type,int start,int end);
	@SQL("select count(1) from game_center_rank where type = :1")
	public int getTotal(int type);
	
}
