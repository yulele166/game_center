package com.qn.gamecenter.dao;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.AppImgRep;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

/**
 * @user 
 * @date 2016年6月15日
 */
@DAO
public interface AppImageDAO {
	public static final String TABLE_NAME="game_center_app_img";
	public static final String TABLE_FIELD ="id,appId,bigUrl,smallUrl,state";
	@SQL("select smallUrl as imgUrl,bigUrl as bigImgUrl from $TABLE_NAME where appId = :1 and state = 1 order by sort limit 5")
	public List<AppImgRep> getImages(int appId);
}
