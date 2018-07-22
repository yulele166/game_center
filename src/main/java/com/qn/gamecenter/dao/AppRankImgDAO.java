package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年6月24日
 */
@DAO
public interface AppRankImgDAO {
	@SQL("select imgUrl from game_center_rank_img where type = :1")
	public String getRankImg(int type);
}
