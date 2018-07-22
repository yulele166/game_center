package com.qn.gamecenter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.dao.SubjectBrowTimeDAO;

/**
 * @user 
 * @date 2016年7月12日
 */
@Service
public class BrowTimesService {
	@Autowired
	private SubjectBrowTimeDAO browTimeDAO;

	public void addTimes(int subId) {
		browTimeDAO.addTimes(subId);
	}
}
