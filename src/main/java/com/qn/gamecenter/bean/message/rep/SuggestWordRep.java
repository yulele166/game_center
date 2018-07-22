package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.ElementRep;

/**
 * 搜索提示词
 * 
 * @user 
 * @date 2016年6月22日
 */
public class SuggestWordRep extends ElementRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1217340644599229737L;
	private List<String> words;
	private List<ElementRep> eles;

	public List<ElementRep> getEles() {
		return eles;
	}

	public void setEles(List<ElementRep> eles) {
		this.eles = eles;
	}

	public List<String> getWords() {
		return words;
	}

	public void setWords(List<String> words) {
		this.words = words;
	}

}
