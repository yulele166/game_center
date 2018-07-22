package com.qn.gamecenter.bean;

/**
 * @user 
 * @date 2016年6月11日
 */
public class Constant {
	public static int DEFAULT_COMMENT_PAGE_INDEX = 1;

	public static int DEFAULT_COMMENT_PAGE_SIZE = 5;

	/** 活动页面列表默认展示数量 */
	public static int DEFAULT_ACTIVITY_PAGE_LIST_SIZE = 3;
	/** 攻略页面列表默认展示数量 **/
	public static int DEFAULT_TACTIC_PAGE_LIST_SIZE = 3;

	/** 活动页面 **/
	public static int ACTIVITY_PAGE = 1;
	/** 攻略页面 **/
	public static int TACTIC_PAGE = 2;
	/** 视频页面 **/
	public static int VIDEO_PAGE = 3;

	public static int GIFT = 4;
	/** 排行榜头部数量 **/
	public static int RANK_TITLE_SIZE = 3;
	/** 排行榜下部的开始位置 **/
	public static int RANK_UNDER_START = 3;
	/** solr 地址 **/
	public static String SOLR_URL = "http://172.16.95.136:8983/solr/game_center/";
	/** 搜索默认开始位置 **/
	public static int START = 0;
	/** 搜索默认数量 **/
	public static int rows = 10;

	public static String SUGGEST_NAME = "suggestName";

	public static String APP_NAME = "appName";
	public static String APP_ID = "id";

	/** 评论长度限制 **/
	public static int COMMENT_SIZE = 30;

	/** 分页大小 ***/
	public static int SUBJECT_CONTENT_SIZE = 20;
	public static int RANK_SIZE = 20;
	public static int CATEGORY_SIZE = 20;
	public static int HTML_PAGE_SIZE = 20;
	
	/** 50100以上版本显示TAB页 ***/
	public static int TAB_SHOW_APP_VERSION = 50202;

    public static int CONFIRM_DISCOVERY_PAGE_APPVERSION = 50202;

    /**
     * 专题对象缓存分页索引用
     **/
    public static int SUBJECT_CACHE_PI = 1;

}
