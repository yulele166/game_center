package com.qn.gamecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.ShowType;
import com.qn.gamecenter.bean.db.Screen;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.dao.AppScreenDAO;

/**
 * 启动屏幕大图相关服务
 * 
 * @user 
 * @date 2016年6月30日
 */
@Service
public class ScreenService {
	@Autowired
	private AppScreenDAO screenDAO;

	@Autowired
	private SubjectService subjectService;

	/**
	 * 获取启屏
	 * 
	 * @return
	 */
	public ElementRep getFirstScreen() {
		Screen screen = screenDAO.getScreen(DateUtil.getTodayDateTimeStr());
		int openType = screen.getOpenType();
		int elementId = screen.getElementId();
		ElementRep rep= subjectService.getElementRep(elementId, openType, 1,
				ShowType.OPEN_APP);
		rep.setImgUrl(screen.getImgUrl());
		return rep;
	}

}
