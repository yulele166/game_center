package com.qn.gamecenter.bean.message.rep.resource;


/**
 * 评论
 * @user 
 * @date 2016年6月15日
 */
public class CommentRep extends ElementRep{
	/** 用户昵称 **/
	private String name;
	/** 评论状态 **/
	private int state;
	/** 评论内容 **/
	private String comment;
	/** 评论时间 **/
	private String createTime;
	/** 评论星数 **/
	private int star;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	
}
