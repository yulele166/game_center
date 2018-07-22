package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.CommentRep;

/**
 * @user 
 * @date 2016年6月15日
 */
public class AppCommentRep extends SharePageRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1590906318964885811L;
	/** 评论列表 **/
	private List<CommentRep> comments;

	public List<CommentRep> getComments() {
		return comments;
	}

	public void setComments(List<CommentRep> comments) {
		this.comments = comments;
	}

}
