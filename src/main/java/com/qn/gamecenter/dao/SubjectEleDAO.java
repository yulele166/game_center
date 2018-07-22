package com.qn.gamecenter.dao;

import java.util.List;

import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import com.qn.gamecenter.bean.db.SubjectElement;

/**
 * 专题元素关联数据表操作
 * @user 
 * @date 2016年6月14日
 */
@DAO
public interface SubjectEleDAO {
	String TABLE_NAME = "game_center_subject_element";
	String TABLE_FIELD = "subjectId,elementId,showType,sort,openType,tagWord,imgType,animationType,showDesc";
	@SQL("select $TABLE_FIELD from $TABLE_NAME where subjectId = :1 order by sort limit :2,:3")
	public List<SubjectElement> getElementById(int id,int start,int end);
	
	@SQL("select $TABLE_FIELD from $TABLE_NAME where subjectId = :1 order by sort")
	public List<SubjectElement> getElementById(int id);
	
	@SQL("select count(1) from $TABLE_NAME where subjectId = :1")
	public int getSubjectEleNum(int subId);
	
}
