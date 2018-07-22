package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * @user 
 * @date 2016年6月28日
 */
@RequestMap(value="suggestWord")
public class GetSuggestWordReq extends RequestMessage{
	private String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
