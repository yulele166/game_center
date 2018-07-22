package com.qn.gamecenter.service;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.bean.db.DbShowType;
import com.qn.gamecenter.dao.ShowTypeDAO;

/**
 * @user 
 * @date 2016年7月10日
 */
@Service
public class ShowTypeService {

	private Map<Integer, Boolean> showTypeMap;

	@Autowired
	private ShowTypeDAO showTypeDAO;

	@PostConstruct
	public void init() {
		showTypeMap = CollectionUtil.hashMap();
		List<DbShowType> types = showTypeDAO.getShowTypes();
		DbShowType type;
		for (int i = 0; i < types.size(); i++) {
			type = types.get(i);
			boolean needShow = type.getNeedShow() == 1 ? true : false;
			showTypeMap.put(type.getShowTypeId(), needShow);
		}
	}

	/**
	 * 是否去要获取专题内的所有内容
	 * 
	 * @param showTypeId
	 * @return
	 */
	public boolean isNeedShow(int showTypeId) {
		if (showTypeMap.containsKey(showTypeId)) {
			return showTypeMap.get(showTypeId);
		}
		return false;
	}
}
