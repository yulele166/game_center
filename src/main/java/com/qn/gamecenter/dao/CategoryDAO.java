package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.CategoryRep;

/**
 * @user 
 * @date 2016年6月1日
 */
@DAO
public interface CategoryDAO {

	@SQL("select id,imgUrl,name from game_center_category where parentId= 0 and needShow = 1")
	public List<CategoryRep> getCategorys();

	@SQL("select id,imgUrl,name from game_center_category where parentId = :1 and needShow = 1")
	public List<CategoryRep> getCategoryByParentId(int parentId);

	@SQL("select id,imgUrl,name from game_center_category where id = :1 ")
	public CategoryRep getCategoryRepById(int cId);
}
