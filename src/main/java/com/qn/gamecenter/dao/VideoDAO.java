package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.resource.VideoRep;

/**
 * 视频相关数据库操作
 * @user 
 * @date 2016年6月13日
 */
@DAO
public interface VideoDAO {
	String TABLE_NAME = "game_center_video";
	String TABLE_FIELDS = "id,address,imgUrl,detailDesc,shortDesc,appId,name";

	@SQL("select $TABLE_FIELDS from $TABLE_NAME where appId = :1 limit :2,:3")
	public List<VideoRep> getVideoById(int id,int start,int end);
	@SQL("select $TABLE_FIELDS from $TABLE_NAME where appId= :1")
	public List<VideoRep> getVideos (int appId);
	
}
