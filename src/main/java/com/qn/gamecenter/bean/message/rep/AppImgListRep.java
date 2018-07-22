package com.qn.gamecenter.bean.message.rep;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.AppImgRep;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;

/**
 * 软件截屏图
 * @user 
 * @date 2016年6月20日
 */
public class AppImgListRep extends ElementRep{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5085826915303359579L;
	private List<AppImgRep> imgs;
	private List<HtmlPageRep> htmls;//软件截屏图中的html元素
	public List<AppImgRep> getImgs() {
		return imgs;
	}

	public void setImgs(List<AppImgRep> imgs) {
		this.imgs = imgs;
	}
	public void setHtmls(List<HtmlPageRep> htmls){
		this.htmls = htmls;
	}
	public List<HtmlPageRep> getHtmls(){
		return htmls;
	}
}
