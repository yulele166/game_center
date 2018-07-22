package com.qn.gamecenter.bean;

import java.lang.reflect.Field;

import net.bull.javamelody.Main;

/**
 * 展示方式
 * 
 * @user 
 * @date 2016年6月16日
 */
public class ShowType {

	/** 专题展示形态 **/
	public final static int DISCOVERY_SIX_MODEL = 100;// 发现页面最上面的六格
	public final static int DISCOVERY_VIDEO_CROSSWISE = 101;// 发现页面中的热门视频
	public final static int DISCOVERY_ACT_HTML = 102;// 发现页面中的热门活动
	public final static int DISCOVERY_TAC_HTML = 103;// 发现页面中的热门攻略
	public final static int CATEGORY_LIST = 104;// 四点
	public final static int DEFAULT_THREE_SUBJECT = 105;// 精品页 固定板式的三格
	public final static int APP_BIG_IMG = 106;// 单品大图
	public final static int HOT_WORD = 107;// 热词
	public final static int VIDOE_CROSSWISE = 108;// 视频并排
	public final static int WITH_OUT_TITLE_LIST = 109;// 不带名称的软件列表
	public final static int APP_BANNER = 110;// 带banner图的app 展示
	public final static int TRUM_PET = 111; // 小喇叭通知展示
	public final static int APP_WITH_HTML = 112;// 带礼包活动的单品专题
	public final static int APP_LIST = 113;// 带标题的app列表
	public final static int SEARCH_PAGE = 114;// 搜索页面中的热词大专题
	public final static int QUALITY_PAGE = 115;// 精品页
	public final static int DISCOVERY_PAGE = 116;// 发现页面
	public final static int THREE_SUBJECT  = 117;//固定三格中的专题
	public final static int FOUR_BUTTON_ELE = 118;//四点中的专题
	/** 元素展示形态 **/
	public final static int DISCOVERY_SIX_MODEL_BIG = 200;// 发现页面六格中最大的
	public final static int DISCOVERY_SIX_MODEL_MIDDLE = 201;// 发现页面六格中 中等大小
	public final static int DISCOVERY_SIX_MODEL_SMALL = 202;// 发现页面中最小的
	public final static int DISCOVERY_VIDEO = 203;// 发现页面中的热门视频中的元素
	public final static int DISCOVERY_HTML = 204;// 发现页面中的攻略活动
	public final static int APP_CROSSWISE = 205;// app横排展示
	public final static int APP_VERTICAL = 206;// app竖排展示
	public final static int APP_WITH_GIFT = 207;// 带礼包的单品展示
	public final static int HOT_WORD_ONLY = 208;// 热词专题下的 只展示词的形态
	public final static int HOT_WORD_APP = 209;// 热词下的单品
	public final static int APP_THREE_CROSSWISE = 210;// app横排展示3个
	public final static int APP_FOUR_CROSSWISE = 211;// app横排展示4个
	public final static int APP_FIVE_CROSSWISE = 212;// app横排展示5个
	public final static int VIDEO_CROSSWISE = 213;// 视频并排下的元素
	public final static int APP_TWO_CROSSWISE = 214;// app横排展示2个
	public final static int APP_SIX_CROSSWISE = 215;// app横排展示6个
	public final static int FOUR_POINT = 216;// 四点
	public final static int APP_VIDOE_CROSSWISE = 217;// 视频横排
	public final static int TRUM_PET_ELEMENT = 218;// 小喇叭中的元素展示
	public final static int SEARCH_PAGE_ELEMENT = 219;// 搜索页面中的热词展示形态
	public final static int OPEN_APP = 220;// 启屏页面
	public final static int TAB_PAGE = 221;// tab页
	public final static int APP_LIST_WITH_GIFT = 222;// 带礼包展示的软件列表页面
	public final static int APP_LIST_WITH_VIDEO = 223;// 带视频展示的软件列表
	public final static int ACT_TAB = 224;// 活动tab
	public final static int SUBJECT_LIST = 225;// 专题列表
	public final static int SEARCH_PAGE_HOT_WORD = 226;//搜索页面中的热词 只展示词的形态
	public final static int SEARCH_PAGE_HOT_WORD_IMG = 227;//搜索页面中的热词 带图片展示
	
	
	public final static int QUALITY_PAGE_FIRST = 301;//精品页一套排期
	

	public final static int BASE_BUM = 1;

	// /*** 视频展示方式 ****/
	// // public final static int VIDEO_CROSSWISE = BASE_BUM++;// 横排展示视频
	// public final static int APP_VS = BASE_BUM++;// vs模块中的单品展示
	// public final static int APP_HEAD = BASE_BUM++;// 精品页头图展示
	// /** 软件展示方式 **/
	// /** 通用展示形态 **/
	// // public final static int APP_CROSSWISE = 4;// app横排展示
	//
	// public final static int THREE_VERTICAL_SUBJECT = BASE_BUM++;// 搜索热词的展示形态
	// public final static int BIG_IMG_WITH_TITLE = BASE_BUM++;// 大图展示，有标题
	//
	// // ++ 排行顶部前三名
	// //
	// // ++ /** 分类展现形式 **/
	// // 分类头部圆形按钮
	// public final static int CATEGORY_TITLE_CYCLO_BUTTON = BASE_BUM++;
	// // ++ 分类卡片页宫格
	// public final static int CATEGORY_CARD = BASE_BUM++;
	// // ++ /** 热词展现形式 **/
	// // ++ 搜索栏轮播展示
	// // 三列并排展示
	// public final static int THRED_BINGLIE_SHOW = BASE_BUM++;
	// // ++ 热词自动填充列表
	// // ++ 搜索页橙色方块热词
	// //
	// // ++ /** 上面标题下面大图专题 **/
	// public final static int TITLE_BIG_IMG_SUBJECT = BASE_BUM++;
	// // ++ /** 上面标题下面卡片页（单品列表） **/
	// public final static int CARD_TITLE_SUBJECT = BASE_BUM++;
	//
	// public final static int APP_INFO_HTML = BASE_BUM++;// 软件详情页中的攻略活动集合页面
	// public final static int APP_GIFT_PAGE = BASE_BUM++;// 礼包页面
	// public final static int CATEGORY_TITLE = BASE_BUM++;// 分类页面上面的专题展示
	// public final static int CATEGORY_PAGE = BASE_BUM++;// 分类页面的分类展示

	public static void main(String[] args) throws IllegalArgumentException,
			IllegalAccessException {
		Field[] fields = ShowType.class.getFields();
		for (int i = 0; i < fields.length; i++) {
			System.out.println(fields[i] + ":" + fields[i].getInt(""));
		}
	}
}
