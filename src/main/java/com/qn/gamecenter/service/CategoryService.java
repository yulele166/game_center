package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.db.CategoryTitle;
import com.qn.gamecenter.bean.message.rep.AppCategoryRep;
import com.qn.gamecenter.bean.message.rep.CategoryAppListRep;
import com.qn.gamecenter.bean.message.rep.CategoryRep;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.dao.CategoryAppDAO;
import com.qn.gamecenter.dao.CategoryDAO;
import com.qn.gamecenter.dao.CategoryTitleDAO;

/**
 * 分类相关服务
 * 
 * @user 
 * @date 2016年6月1日
 */
@Service
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private CategoryTitleDAO categoryTitleDAO;

	@Autowired
	private CategoryAppDAO categoryAppDAO;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private RedisService redisService;

	@Autowired
	private SharePageService pageService;

	@Autowired
	private AppInfoService appInfoService;

	@Autowired
	private RedisKeyService redisKeyService;

	/**
	 * 获取所有分类信息
	 * 
	 * @return
	 */
	public AppCategoryRep getAllCategorys() {
		Object obj = redisService.getObjValue(RedisKey.CATEGORY_LIST);
		if (obj != null) {
			return (AppCategoryRep) obj;
		}
		List<ElementRep> eles = CollectionUtil.arrayList();
		// 获取礼包头部专题信息
		List<CategoryTitle> titles = categoryTitleDAO.getCategoryTitle();
		for (CategoryTitle title : titles) {
			ElementRep ele = subjectService.getElementRep(title.getSubjectId(),
					title.getOpenType(), title.getSort(), title.getOpenType());
			ele.setImgUrl(title.getImgUrl());
			eles.add(ele);
		}
		// 获取分类相关信息
		List<CategoryRep> categorys = categoryDAO.getCategorys();
		for (CategoryRep c : categorys) {
			int parentId = c.getId();
			List<CategoryRep> childCategory = categoryDAO
					.getCategoryByParentId(parentId);
			c.setCs(childCategory);
		}
		AppCategoryRep rep = new AppCategoryRep();
		rep.setCs(categorys);
		rep.setTitles(eles);
		redisService.setObjValue(RedisKey.CATEGORY_LIST, rep);
		return rep;
	}

	/**
	 * 获取分类优先展示的软件
	 * 
	 * @param cId
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShortAppInfoRep> getCategoryApps(int cId) {
		List<ShortAppInfoRep> apps = null;
		String idStr = cId + "";
		// 先看缓存
		Object obj = redisService.getHashObjectValue(RedisKey.CATEGORY_APP,
				idStr);
		if (obj != null) {
			apps = (List<ShortAppInfoRep>) obj;
		} else {
			apps = categoryAppDAO.getCategoryApps(cId);
			if (apps != null && apps.size() != 0) {
				redisService.addHashObjectValue(RedisKey.CATEGORY_APP, idStr,
						apps);
			}
		}
		return apps;
	}

	/**
	 * 获取对应分类的软件
	 * 
	 * @param cid
	 * @param pi
	 * @param ps
	 * @return
	 */
	public CategoryAppListRep getAppInfosById(int cId, int pi) {
		int ps = Constant.CATEGORY_SIZE;
		CategoryAppListRep rep = new CategoryAppListRep();
		List<ShortAppInfoRep> apps = buildApps(cId, pi);
		rep.setApps(apps);
		int totalNum = appInfoService.getCategoryTotalNum(cId);
		pageService.buildSharePage(rep, pi, ps, totalNum);
		return rep;
	}

	/**
	 * 构建分类信息中的集合
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShortAppInfoRep> buildApps(int cId, int pi) {
		List<ShortAppInfoRep> apps = null;
		int end = pageService.getEnd(pi, Constant.CATEGORY_SIZE);
		int start = pageService.getStart(pi, Constant.CATEGORY_SIZE);
		String key = redisKeyService.getCategorySharePageKey(cId + "");
		// 取缓存
		Object obj = redisService.getHashObjectValue(key, pi + "");
		if (obj != null) {
			apps = (List<ShortAppInfoRep>) obj;
		} else {
			// 取优先显示的软件
			List<ShortAppInfoRep> firstApps = getCategoryApps(cId);
			// 获取正常展示的软件列表
			List<ShortAppInfoRep> normalApps = appInfoService.getAppInfos(cId,
					start, end);
			normalApps.removeAll(firstApps);
			// 如果是第一页 优先展示的软件在最前面
			if (pi == 1) {
				firstApps.addAll(normalApps);
				apps = firstApps;
			} else {
				apps = normalApps;
			}
			redisService.addHashObjectValue(key, pi + "", apps);
		}
		return apps;
	}

	public CategoryRep getCategory(int cid) {
		return categoryDAO.getCategoryRepById(cid);
	}

}
