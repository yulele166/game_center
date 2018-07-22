package com.qn.gamecenter.bean.message.req;

import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;

/**
 * @user 
 * @date 2016年6月28日
 */
@RequestMap(value="search")
public class GetSearchResult extends RequestMessage{
	private String word;
	private int pi;
	

	public int getPi() {
		return pi;
	}

	public void setPi(int pi) {
		this.pi = pi;
	}


	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
