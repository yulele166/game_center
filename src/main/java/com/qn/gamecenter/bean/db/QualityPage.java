package com.qn.gamecenter.bean.db;

/**
 * 精品页面配置
 * 
 * @user 
 * @date 2016年6月23日
 */
public class QualityPage {
	private int subjectId;// 专题id
	private String start;// 开始时间
	private String end;// 结束时间
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

}
