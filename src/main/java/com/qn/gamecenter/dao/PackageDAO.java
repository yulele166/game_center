package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.db.DbPackage;

/**
 * @user 
 * @date 2016年7月5日
 */
@DAO
public interface PackageDAO {
	String TABLE_NAME = "game_center_package";
	String TABLE_FIELDS = "id,channel,version,address,sign,createTime,descs,md5,versionCode";

	@SQL("select $TABLE_FIELDS from $TABLE_NAME where version=:1 and channel=:2")
	public String getPackageAdd(String version, String channel);

	/**
	 * 获取所有渠道最新的安装包信息
	 * 
	 * @return
	 */
	@SQL("select a.* from $TABLE_NAME a where version = (select max(version) from game_center_package where channel  = a.channel) order by version;")
	public List<DbPackage> getAllLastPackages();
	/**
	 * 获取升级包屏蔽的版本号
	 * @return
	 */
	@SQL("select grepVersion from game_center_package_grep_version")
	public List<Integer> getGrepVersions();
	
	
	
}
