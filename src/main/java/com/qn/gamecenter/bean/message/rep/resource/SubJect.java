package com.qn.gamecenter.bean.message.rep.resource;

import java.util.List;

import com.qn.gamecenter.bean.OpenType;
import com.qn.gamecenter.bean.message.rep.SharePageRep;

/**
 * 专题
 * 
 * @user 
 * @date 2016年6月13日
 */
public class SubJect extends SharePageRep {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4761066018233400399L;
	private String bannerImg;
	private int browTimes;
	private List<ElementRep> eles;// 专题种包含的元素

	public List<ElementRep> getEles() {
		return eles;
	}

	public void setEles(List<ElementRep> eles) {
		this.eles = eles;
	}

	public String getBannerImg() {
		return bannerImg;
	}

	public void setBannerImg(String bannerImg) {
		this.bannerImg = bannerImg;
	}

	public int getBrowTimes() {
		return browTimes;
	}

	public void setBrowTimes(int browTimes) {
		this.browTimes = browTimes;
	}

	public SubJect() {
		this.openType = OpenType.OPEN_SUBJECT_PAGE;
	}

}
