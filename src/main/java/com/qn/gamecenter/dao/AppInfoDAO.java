package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.message.rep.RankAppInfoRep;
import com.qn.gamecenter.bean.message.rep.UpdateAppInfoRep;
import com.qn.gamecenter.bean.message.rep.resource.AppInfoRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;

/**
 * @user 
 * @date 2016年6月2日
 */
@DAO
public interface AppInfoDAO {
	public static final String TABLE_NAME = "game_center_app_info";

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,version,versionSize as size from $TABLE_NAME where classId = :1 and isDef=1 order by isCp desc,lastUpdateTime desc limit :2,:3")
	public List<ShortAppInfoRep> getAppInfos(int cid, int start, int end);

	@SQL("select version,versionSize as size,phoneNum,praise,totalDownload,icon as imgUrl,shortDesc,appName as name,detailDesc,tag,language,download,newHot,quality,profit,crc,downloadUrl,packageName,safeTag,author as creator,className,versionName,starNum,starUserNum  from $TABLE_NAME where appId = :1 ")
	public AppInfoRep getAppInfoById(int appId);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version from $TABLE_NAME where appId=:1 ")
	public ShortAppInfoRep getShortAppInfo(int appId);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version from $TABLE_NAME where appName=:1 AND isDef=1 ORDER BY appId DESC LIMIT 1 ")
	ShortAppInfoRep getShortAppInfoByAppName(String appName);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version from $TABLE_NAME where appId=:1 ")
	public RankAppInfoRep getRankAppInfo(int appId);

	@SQL("select count(1) from game_center_app_info where classId=:1 ")
	public int getTotalNum(int type);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version from $TABLE_NAME where packageName in (:1) ")
	public List<ShortAppInfoRep> getAppByPkgNames(List<String> names);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version,auto from $TABLE_NAME where packageName in (:1) ")
	public List<UpdateAppInfoRep> getUpAppByPkgNames(List<String> names);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version,auto from $TABLE_NAME where packageName in (:1)  and classId!=0")
	public List<UpdateAppInfoRep> getOldUpAppByPkgNames(List<String> names);

	@SQL("select appId,appName as name,shortDesc,icon as imgUrl,packageName,crc,tag,downloadUrl,versionSize as size,versionName,version from $TABLE_NAME where appId in (:1) and isDef=1 order by FIELD(appId,:1) ")
	public List<ShortAppInfoRep> getAppByAppIds(List<Integer> appIds);

	/**
	 * 获取推荐app 类型1 华为 2 为非华为
	 * 
	 * @param type
	 * @return
	 */
	@SQL("select appId from game_center_recommend_app where type=:1 order by sort")
	public List<Integer> getRecomendAppInfo(int type);

}
