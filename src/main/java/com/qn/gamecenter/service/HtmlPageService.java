package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.message.rep.AppHtmlListRep;
import com.qn.gamecenter.bean.message.rep.AppHtmlPageRep;
import com.qn.gamecenter.bean.message.rep.HtmlWithNumRep;
import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;
import com.qn.gamecenter.dao.HtmlPageDAO;

/**
 * html页面相关服务
 * 
 * @user 
 * @date 2016年6月15日
 */
@Service
public class HtmlPageService {
	@Autowired
	private HtmlPageDAO htmlPageDAO;

	@Autowired
	private SharePageService pageService;

	/**
	 * 获取默认列表数量
	 * 
	 * @param appId
	 * @param type
	 * @return
	 */
	private List<HtmlPageRep> getHtmlPageByType(int appId, int type, int pi,
			int ps) {
		int start;
		int end;
		if (pi <= 0 && ps <= 0) {
			start = 0;
			end = Constant.DEFAULT_ACTIVITY_PAGE_LIST_SIZE;
		} else {
			start = (pi - 1) * ps;
			end = start + ps;
		}
		return htmlPageDAO.getHtmlPageById(appId, start, end, type);
	}

	/**
	 * 获取活动页面
	 * 
	 * @param appId
	 * @return
	 */
	public List<HtmlPageRep> getActivityPage(int appId, int pi, int ps) {
		return getHtmlPageByType(appId, Constant.ACTIVITY_PAGE, pi, ps);
	}

	/**
	 * 获取攻略页面
	 * 
	 * @param appId
	 * @return
	 */
	public List<HtmlPageRep> getTacticPage(int appId, int pi, int ps) {
		return getHtmlPageByType(appId, Constant.TACTIC_PAGE, pi, ps);
	}

	/**
	 * 获取攻略页面
	 * 
	 * @param appId
	 * @return
	 */
	public List<HtmlPageRep> getVideoPage(int appId) {
		return getHtmlPageByType(appId, Constant.VIDEO_PAGE, 0, 0);
	}

	/**
	 * 获取对应页面
	 * 
	 * @param appId
	 * @param pi
	 * @param type
	 * @return
	 */
	public AppHtmlPageRep getHtmls(int appId, int pi, int type) {
		int ps = Constant.HTML_PAGE_SIZE;
		int start = pageService.getStart(pi, ps);
		int end = ps;
		List<HtmlPageRep> htmls = htmlPageDAO.getHtmlPageById(appId, start,
				end, type);
		AppHtmlPageRep rep = new AppHtmlPageRep();
		int totalNum = getTotal(appId, type);
		rep.setHtmls(htmls);
		pageService.buildSharePage(rep, pi, ps, totalNum);
		return rep;
	}

	/**
	 * 获取一共有多少
	 * 
	 * @param appId
	 * @param type
	 * @return
	 */
	public int getTotal(int appId, int type) {
		return htmlPageDAO.getTotalNum(appId, type);
	}

	/**
	 * 获取攻略 活动的集合页面
	 * 
	 * @param appId
	 */
	public AppHtmlListRep getHtmlList(int appId) {
		AppHtmlListRep rep = new AppHtmlListRep();
		List<HtmlPageRep> actPages = getActivityPage(appId,
				Constant.DEFAULT_COMMENT_PAGE_INDEX,
				Constant.DEFAULT_ACTIVITY_PAGE_LIST_SIZE);
		List<HtmlPageRep> tacPages = getTacticPage(appId,
				Constant.DEFAULT_COMMENT_PAGE_INDEX,
				Constant.DEFAULT_TACTIC_PAGE_LIST_SIZE);
		rep.setActPages(actPages);
		rep.setStrPages(tacPages);
		return rep;
	}

	/**
	 * 获取某个html页面
	 * 
	 * @param htmlId
	 * @return
	 */
	public HtmlPageRep getHtml(int htmlId) {
		return htmlPageDAO.getHtmlPage(htmlId);
	}

	/**
	 * 获取某个html页面
	 * 
	 * @param
	 * @return
	 */
	public HtmlWithNumRep getHtmlByType(int type) {

		return htmlPageDAO.getHtmlPageByType(type);
	}
	
	public int getHtmlNums(int appId){
		return htmlPageDAO.getHtmlNum(appId);
	}

	/**
	 * 获取软件截屏图位置显示的视频资源
	 * @param appId
	 * @return
     */
	public List<HtmlPageRep> getImgHtmlList(int appId){
		List<HtmlPageRep> htmls = htmlPageDAO.getAppInfoVideo(appId);
		return htmls;
	}
}
