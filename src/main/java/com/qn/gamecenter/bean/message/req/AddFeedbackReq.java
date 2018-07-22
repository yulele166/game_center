package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * 添加反馈信息
 * 
 * @user 
 * @date 2016年8月2日
 */
@RequestMap(value = "addFeedback")
public class AddFeedbackReq extends RequestMessage {
	private String content;// 反馈内容
	private String contact;// 联系方式

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
