package com.qn.gamecenter.bean;

/**
 * @user 
 * @date 2016年7月13日
 */
public class RedisKey {
	/** 礼包码 **/
	public static String GIFT_CODE_PRE = "gift:";
	/** 领取过的礼包 **/
	public static String HAS_RECEIVE_GIFT = "rec:gift:";
	/** 专题内容的前缀 **/
	public static String SUBJECT_CONTENT_PRE = "subject:";
	/** 精品页排期 **/
	public static String QUALITY_PAGE_ID = "quality";
	/** 一套排期 **/
	public static String QUALITY_SEPRE_PAGE_ID = "sepre:quality";
	/** 发现页面排期 **/
	public static String DISCOVERY_PAGE_ID = "discovery";
	/** 搜索页面排期 **/
	public static String SEARCH_PAGE_ID = "search";
	/** tab页面排期 **/
	public static String TAB_PAGE = "tab";
	/** 精品页头图 **/
	public static String QUALITY_PAGE_TITLE_ID = "quality:title";
	public static String QUALITY_PAGE_SEPRE_TITLE_ID = "quality:title:sepre";
	
	/** 分类列表 **/
	public static String CATEGORY_LIST = "category:list";
	/** 开关列表 **/
	public static String SWITCH_LIST = "switch:list";
	
	/** 专题打开次数 */
	public static String SUBJECT_OPEN_TIMES = "subject:open:times";
	/** 搜索热词关联app 的 haskkey **/
	public static String HOT_WORD_APP = "hot:word:app";
	/** 排行榜 **/
	public static String RANK = "rank:page:";
	/** 预览排期的ID */
	public static String QUALITY_PAGE_FUTURE = "quality:future";
	/** 预览一套排期**/
	public static String QUALITY_PAGE_SEPRE_FUTURE = "quality:sepre:future";

	/** 每天的搜索词排行 与日起拼接 **/
	public static String SEARCH_WORD_TIMES = "search:word:";
	
	/** 每天的活跃用户 与日期拼接 **/
	public static String DAY_ACTIVITY_USER = "day:activity:user:";
	/**升级包相关 */
	public static String UPDATE_APPS = "update:package";
	/** 分类优先展示软件 **/
	public static String CATEGORY_APP ="category:app";
	/** 分类分页数据缓存 **/
	public static String CATEGORY_SHARE_PAGE="category:share:page:";
	/** 当天调用过礼包列表的imei **/
	public static String GET_GIFT_REQUEST = "get:gift:list:";
	/** 当天调用过起屏页面的imei**/
	public static String GET_FIRST_SCREEN = "get:first:screen:";
	/** 当天访问过精品页面的imei **/
	public static String GET_QUALITY_PAGE = "get:quality:page:";
	/** 访问更新接口 */
	public static String UPDATE_APP_INFO = "update:app";
	/** tab页排期 */
	public static String GET_TAB_PAGE = "get:tab:page";

    /**
     * 发现页面二排期
     **/
    public static String DISCOVERY_SECOND_PAGE_ID = "discovery:second";
    /**
     * 推荐词关联元素集合 hashkey
     */
    public static String SUGGESTWORD_ELEMENT = "suggestword:element";
    /**升级包信息**/
    public static String UPDATE_PKG_INFO = "update:package:info";
    /**
     * 预览头图排期的ID
     */
    public static String QUALITY_PAGE_TITLE_FUTURE = "quality:title:future";
    /**
     * 预览头图排期的ID
     */
    public static String QUALITY_PAGE_TITLE_FUTURE_SEPRE = "quality:title:future:sepre";
    
    
}
