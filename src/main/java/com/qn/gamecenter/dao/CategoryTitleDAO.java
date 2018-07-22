package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.db.CategoryTitle;

/**
 * @user 
 * @date 2016年6月24日
 */
@DAO
public interface CategoryTitleDAO {
	@SQL("select id,subjectId,openType,sort,imgUrl from game_center_category_title order by sort ")
	public List<CategoryTitle> getCategoryTitle();
}
