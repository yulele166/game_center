package com.qn.gamecenter.service;

import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.message.rep.SharePageRep;

/**
 * 分页相关服务
 * 
 * @user 
 * @date 2016年6月24日
 */
@Service
public class SharePageService {
	public void buildSharePage(SharePageRep rep, int pi, int ps, long totalNum) {
		rep.setPi(pi);
		rep.setPs(ps);
		rep.setTotalNum(totalNum);
		rep.setTotalPage((int) (totalNum / ps + 1));
	}

	/**
	 * 开始点
	 * 
	 * @param pi
	 * @param ps
	 * @return
	 */
	public int getStart(int pi, int ps) {
		return (pi - 1) * ps;
	}

	/**
	 * 获取截止点
	 * 
	 * @param pi
	 * @param ps
	 * @return
	 */
	public int getEnd(int pi, int ps) {
		return ps;
	}

}
