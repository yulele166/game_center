package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;

/**
 * 分类页面人工控制app相关数据库操作 game_center_category_app
 * 
 * @user 
 * @date 2016年9月13日
 */
@DAO
public interface CategoryAppDAO {

	String TABLE = "game_center_category_app";

	String TABLE_FIELD = "appId,appName,imgType,animationType,tagWord";

	/**
	 * 获取分类信息中的优先展示软件信息
	 * <p>
	 * 分类中的配置软件信息第一次获取之后会寸与缓存之中，这里的关联查询无大影响
	 * <p>
	 * 
	 * @param categoryId
	 *            分类id
	 * @return
	 */
	@SQL("select a.appId,a.appName as name,a.shortDesc,a.icon as imgUrl,"
			+ "a.packageName,a.crc,a.tag,a.downloadUrl,a.versionSize as size,"
			+ "a.versionName,a.version,b.imgType,b.animationType,b.tagWord as word"
			+ " from game_center_category_app b left join game_center_app_info a on b.appId = a.AppId where b.isDef=1 and b.categoryId =:1 order by b.sort")
	public List<ShortAppInfoRep> getCategoryApps(int categoryId);

}
