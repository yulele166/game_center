package com.qn.gamecenter.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppCommentRep;
import com.qn.gamecenter.bean.message.req.AddCommentReq;
import com.qn.gamecenter.bean.message.req.AddFeedbackReq;
import com.qn.gamecenter.bean.message.req.GetCommentsReq;
import com.qn.gamecenter.service.CommentService;
import com.qn.gamecenter.service.MessageService;

/**
 * 评论相关接口
 * 
 * @user 
 * @date 2016年6月15日
 */
@Path("/comment/")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@Autowired
	private MessageService messageService;

	/**
	 * 获取评论列表
	 * 
	 * @param appId
	 * @param pi
	 * @param ps
	 * @return
	 */
	@Get("/getComments")
	public AppCommentRep getComment(GetCommentsReq req, Invocation inv) {
		return commentService.getComments(req.getAppId(), req.getPi());
	}

	/**
	 * 添加评论
	 * 
	 * @param req
	 */
	@Get("/addComment")
	public void addComment(AddCommentReq req, Invocation inv) {
		commentService.addComment(req, inv);
	}

	/**
	 * 添加反馈
	 */
	@Get("/addFeedback")
	public void addFeedback(AddFeedbackReq req, Invocation inv) {
		String content = req.getContent();
		String contact = req.getContact();
		String imei = req.getBaseInfo().getImei();
		commentService.addFeedback(content, contact, imei);
	}
}
