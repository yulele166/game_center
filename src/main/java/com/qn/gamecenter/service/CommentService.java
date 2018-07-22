package com.qn.gamecenter.service;

import java.util.List;

import net.paoding.rose.web.Invocation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.ErrorCodeConstant;
import com.qn.gamecenter.bean.message.rep.AppCommentRep;
import com.qn.gamecenter.bean.message.rep.resource.CommentRep;
import com.qn.gamecenter.bean.message.req.AddCommentReq;
import com.qn.gamecenter.bean.message.req.BaseInfoReq;
import com.qn.gamecenter.dao.CommentDAO;
import com.qn.gamecenter.dao.FeedbackDAO;

/**
 * 评论相关服务
 * 
 * @user 
 * @date 2016年6月14日
 */
@Service
public class CommentService {
	@Autowired
	private CommentDAO commentDAO;

	@Autowired
	private FeedbackDAO feedbackDAO;

	@Autowired
	private SharePageService pageService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private FilterWordService filterWordService;

	/**
	 * 获取对应app的评论 ，按照时间排序
	 * 
	 * @param appId
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	public AppCommentRep getComments(int appId, int pi) {
		int ps = 10;
		int start = pageService.getStart(pi, ps);
		int end = pageService.getEnd(pi, ps);
		List<CommentRep> comments = commentDAO.getCommentByAppId(appId, start,
				end);
		AppCommentRep appCommentRep = new AppCommentRep();
		appCommentRep.setComments(comments);
		int totalNum = commentDAO.getTotalNum(appId);
		pageService.buildSharePage(appCommentRep, pi, ps, totalNum);
		return appCommentRep;
	}

	/**
	 * 添加评论
	 * 
	 * @param req
	 */
	public void addComment(AddCommentReq req, Invocation inv) {
		BaseInfoReq baseInfo = req.getBaseInfo();
		// 检测敏感词
		if (filterWordService.isContentKeyWords(req.getComment())) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.KEY_WORD);
			return;
		}
		//检测名字是否有敏感词
		if (filterWordService.isContentKeyWords(req.getName())) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.KEY_WORD);
			return;
		}
		// 检测状态
		if (checkState(req.getAppId(), baseInfo.getImei(), req.getComment(),
				inv)) {
			commentDAO.addComment(req, DateUtil.getTodayDateTimeStr(),
					baseInfo.getImei());
		}
	}

	/**
	 * 检测是否可以提交评论 每个imei 针对一款 app只能提交一次评论 且评论最多25个字
	 * 
	 * @param appId
	 * @param imei
	 * @return
	 */
	public boolean checkState(int appId, String imei, String commentStr,
			Invocation inv) {
		// 评论内容的长度判断
		if (StringUtils.isEmpty(commentStr)) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.COMMENT_IS_NULL);
			return false;
		}
		if (commentStr.length() >= Constant.COMMENT_SIZE) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.COMMENT_MAX_SIZE);
			return false;
		}
		// 是否已经评论过
		CommentRep comment = commentDAO.getComment(appId, imei);
		if (comment != null) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.HAD_COMMENT);
			return false;
		}
		return true;
	}

	/**
	 * 添加反馈信息
	 * 
	 * @param content
	 * @param contact
	 */
	public void addFeedback(String content, String contact, String imei) {
		if (!checkParam(content, contact, imei)) {
			return;
		}
		feedbackDAO.addFeedback(content, contact, imei);

	}

	/**
	 * 检测反馈参数是否正确
	 * 
	 * @param content
	 * @param contact
	 * @param imei
	 * @return
	 */
	private boolean checkParam(String content, String contact, String imei) {
		if (StringUtils.isEmpty(contact)) {
			return false;
		}
		if (StringUtils.isEmpty(content) || content.length() > 200) {
			return false;
		}
		if (StringUtils.isEmpty(imei)) {
			return false;
		}
		return true;
	}

}
