package com.qn.gamecenter.dao;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.resource.SubJect;

/**
 * @user 
 * @date 2016年6月14日
 */
@DAO
public interface SubjectDAO {
	
	@SQL("select id,showType,name,shortDesc,detailDesc,imgUrl,bannerImg from game_center_subject where id =:1")
	public SubJect getSubject(int id);
	

}
