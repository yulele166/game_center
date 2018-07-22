package com.qn.gamecenter.dao;

import com.qn.gamecenter.bean.db.SubjectElement;
import net.paoding.rose.jade.annotation.DAO;
import net.paoding.rose.jade.annotation.SQL;

import java.util.List;

/**
 * Created by 曹大地 on 2016/11/6.
 */
@DAO
public interface SuggestWordEleDAO {

    String TABLE = "game_center_suggest_word";

    String TABLE_NAME = "game_center_suggestword_element";
    String TABLE_FIELD = "subjectId,elementId,showType,sort,openType,tagWord,imgType,animationType";

    @SQL("select $TABLE_FIELD from $TABLE_NAME where subjectId = :1 order by sort limit :2,:3")
    public List<SubjectElement> getElementById(int id, int start, int end);

    @SQL("select $TABLE_FIELD from $TABLE_NAME where subjectId = :1 order by sort")
    public List<SubjectElement> getElementById(int id);

    @SQL("select count(1) from $TABLE_NAME where subjectId = :1")
    public int getSubjectEleNum(int subId);

    @SQL("select id from $TABLE where name = :1")
    Integer getSuggestWordIdByName(String suggestwordName);

    @SQL("select $TABLE_FIELD from $TABLE_NAME where suggestwordId = :1 AND subjectId=0 order by sort")
    public List<SubjectElement> getElementByIdFirst(int id);
}
