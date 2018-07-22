package com.qn.gamecenter.controllers;

import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.AppCategoryRep;
import com.qn.gamecenter.bean.message.rep.CategoryAppListRep;
import com.qn.gamecenter.bean.message.req.GetCategoryApp;
import com.qn.gamecenter.service.AppInfoService;
import com.qn.gamecenter.service.CategoryService;

/**
 * 分类相关
 * 
 * @user 
 * @date 2016年6月1日
 */
@Path("/category/")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@Autowired
	private AppInfoService appInfoService;

	/**
	 * 获取分类信息
	 * 
	 * @return
	 */
	@Get("/getAllCategory")
	public AppCategoryRep getAllCategory() {
		return categoryService.getAllCategorys();
	}

	/**
	 * 获取对应分类列表
	 * 
	 * @param cid
	 *            分类id
	 * @param pi
	 *            列表页码
	 * @param ps
	 *            数量
	 * @return
	 */
	@Get("/getAppsByCid")
	public CategoryAppListRep getAppsByCid(GetCategoryApp req) {
		return categoryService.getAppInfosById(req.getcId(), req.getPi());
	}

}
