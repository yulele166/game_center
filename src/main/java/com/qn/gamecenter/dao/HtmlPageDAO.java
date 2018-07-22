package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.HtmlWithNumRep;
import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;

/**
 * html页面资源
 * 
 * @user 
 * @date 2016年6月14日
 */
@DAO
public interface HtmlPageDAO {

	String TABLE_NAME = "game_center_html";
	String TABLE_FIELDS = "id,address,imgUrl,detailDesc,shortDesc,appId,name,createTime,type";

	@SQL("select $TABLE_FIELDS from $TABLE_NAME where appId = :1 and type=:4 and isShow=0 order by createTime desc limit :2,:3 ")
	public List<HtmlPageRep> getHtmlPageById(int id, int start, int end,
			int type);

	@SQL("select $TABLE_FIELDS from $TABLE_NAME where id = :1")
	public HtmlPageRep getHtmlPage(int htmlId);

	@SQL("select count(1) from $TABLE_NAME where appId = :1 and type =:2 and isShow = 0")
	public int getTotalNum(int appId, int type);

	@SQL("select $TABLE_FIELDS from $TABLE_NAME where type = :1 and isShow = 0 limit 1")
	public HtmlWithNumRep getHtmlPageByType(int type);

	@SQL("select count(1) from $TABLE_NAME where type != 3 and appId = :1")
	public int getHtmlNum(int appId);

	@SQL("select address,imgUrl,type,appId from $TABLE_NAME where appId =:1 and isShow = 1")
	public List<HtmlPageRep> getAppInfoVideo(int appId);
}
