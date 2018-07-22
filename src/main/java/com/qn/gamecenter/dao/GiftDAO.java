package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.resource.GiftRep;

/**
 * 礼包数据库操作
 * 
 * @user 
 * @date 2016年6月15日
 */
@DAO
public interface GiftDAO {
	/**
	 * 获取礼包列表
	 * 
	 * @param appId
	 * @return
	 */
	@SQL("select id,name,appId,expireDate,num,shortDesc,detailDesc,totalDate,packageName from game_center_gift where appId = :1")
	public List<GiftRep> getGifts(int appId);

	/**
	 * 获取礼包列表
	 * 
	 * @param appId
	 * @return
	 */
	@SQL("select id,name,appId,expireDate,num,shortDesc,detailDesc,totalDate,packageName from game_center_gift where appId = :1 limit 1")
	public GiftRep getGift(int appId);

	@SQL("select count(1) from game_center_gift where appId = :1")
	public int getGiftNum(int appId);

	@SQL("update game_center_gift set num = num-1 where id = :1")
	public void changeNum(int giftId);

	/**
	 * 根据礼包id获取礼包信息
	 * 
	 * @param giftId
	 * @return
	 */
	@SQL("select id,name,appId,expireTimes,num,shortDesc,detailDesc,totalDate,packageName,icon from game_center_gift where id = :1")
	public GiftRep getGiftById(int giftId);
	
	
	/**
	 * 根据礼包id获取对应软件
	 * 
	 * @param giftId
	 * @return
	 */
	@SQL("select appId from game_center_gift where id = :1")
	public int getAppIdByGiftId(int giftId);
	
	/**
	 * 礼包领取日志记录
	 * @param giftId
	 * @param code
	 * @param imei
	 */
	@SQL("insert into game_center_gift_receive_log (giftId,code,imei) values (:1,:2,:3)")
	public void giftReceiveLog(int giftId,String code,String imei);

}
