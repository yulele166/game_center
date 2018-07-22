package com.qn.gamecenter.bean;

/**
 * 错误代码
 * 
 * @user 
 * @date 2016年7月5日
 */
public class ErrorCodeConstant {
	public static int NO_UPDATE = -1;
	/** tab 相关 **/
	public static int NO_TAB = 10;
	/** 已经提交过评论 **/
	public static int HAD_COMMENT = 20;
	/** 超过字数限制 **/
	public static int COMMENT_MAX_SIZE = 21;
	/** 评论为空 **/
	public static int COMMENT_IS_NULL = 22;
	/** 礼包已经领取完毕 **/
	public static int GIFT_NULL = 30;
	/** 礼包过期 **/
	public static int GIFT_EXPIRE = 31;
	/** 已经领取过该礼包 **/
	public static int HAS_RECEIVE_GIFT = 32;
	/** 敏感词 **/
	public static int KEY_WORD = 40;
}
