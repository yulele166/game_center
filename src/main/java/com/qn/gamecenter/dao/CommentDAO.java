package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.resource.CommentRep;
import com.qn.gamecenter.bean.message.req.AddCommentReq;

/**
 * 评论表相关操作
 * 
 * @user 
 * @date 2016年6月14日
 */
@DAO
public interface CommentDAO {
	public static final String TABLE_NAME = "game_center_comment";
	public static final String TABLE_FIELD = "comment,appId,name,imei,createTime,state";

	@SQL("select comment,star,name,createTime,state from $TABLE_NAME where appId = :1  order by createTime desc limit :2,:3 ")
	public List<CommentRep> getCommentByAppId(int appId, int start, int end);

	@SQL("select count(1) from $TABLE_NAME where appId= :1")
	public int getTotalNum(int appId);

	@SQL("insert into game_center_comment(comment,appId,name,star,createTime,imei) values(:1.comment,:1.appId,:1.name,:1.star,:2,:3)")
	public void addComment(AddCommentReq req, String date, String imei);

	@SQL("select name from $TABLE_NAME  where appId=:1 and imei=:2 limit 1")
	public CommentRep getComment(int appId, String imei);
}
