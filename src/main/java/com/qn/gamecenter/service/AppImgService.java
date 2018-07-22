package com.qn.gamecenter.service;

import java.util.List;

import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.message.rep.AppImgListRep;
import com.qn.gamecenter.bean.message.rep.resource.AppImgRep;
import com.qn.gamecenter.dao.AppImageDAO;

/**
 * 软件展示图服务
 * 
 * @user 
 * @date 2016年6月15日
 */
@Service
public class AppImgService {
	@Autowired
	private AppImageDAO appImageDAO;

	@Autowired
	private HtmlPageService htmlPageService;


	/**
	 * 获取对应app的图片
	 * @param appId
	 * @return
	 */
	public AppImgListRep getImages(int appId) {
		List<AppImgRep> imgs = appImageDAO.getImages(appId);
		AppImgListRep rep = new AppImgListRep();
		rep.setImgs(imgs);
		//获取软件截屏图位置的资源
		List<HtmlPageRep> htmls = htmlPageService.getImgHtmlList(appId);
		rep.setHtmls(htmls);
		return rep;
	}
}
