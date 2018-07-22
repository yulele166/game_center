package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.message.rep.resource.VideoRep;
import com.qn.gamecenter.dao.VideoDAO;

/**
 * @user 
 * @date 2016年6月15日
 */
@Service
public class VideoService {
	
	@Autowired
	private VideoDAO dao;
	/**
	 * 获取对应app的视频集合
	 * @param appId
	 * @return
	 */
	public List<VideoRep> getVideos(int appId,int start,int end){
		return dao.getVideoById(appId, start, end);
	}
}
