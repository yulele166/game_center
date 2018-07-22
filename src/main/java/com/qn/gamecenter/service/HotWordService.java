package com.qn.gamecenter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.dao.HotWordDAO;

/**
 * 热词相关服务
 * 
 * @user 
 * @date 2016年7月21日
 */
@Service
public class HotWordService {
	@Autowired
	private HotWordDAO hotWordDAO;
	@Autowired
	private AppInfoService appInfoService;

	@Autowired
	private RedisService redisService;

	/**
	 * 获取热词相关的软件
	 * 
	 * @param word
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ShortAppInfoRep> getApps(String word) {
		List<ShortAppInfoRep> apps;
		// 先取缓存
		Object obj = redisService.getHashObjectValue(RedisKey.HOT_WORD_APP,
				word);
		if (obj != null) {
			apps = (List<ShortAppInfoRep>) obj;
		} else {
			List<Integer> appIds = hotWordDAO.getHotWordAppIds(word);
			apps = appInfoService.getApps(appIds);
            //热词配置软件信息的标签，动画效果处理
            for (ShortAppInfoRep shortAppInfoRep : apps) {
                ShortAppInfoRep hotwordWordApp = hotWordDAO.getHotWord(word, shortAppInfoRep.getAppId());
                buildAppTag(shortAppInfoRep, hotwordWordApp.getImgType(), hotwordWordApp.getAnimationType(), hotwordWordApp.getWord());
            }
            if (apps != null && apps.size() != 0) {
				redisService.addHashObjectValue(RedisKey.HOT_WORD_APP, word,
						apps);
			}
		}
		return apps;
	}

    private void buildAppTag(ShortAppInfoRep app, int imgType,
                             int animationType, String word) {
        app.setAnimationType(animationType);
        app.setImgType(imgType);
        app.setWord(word);
    }

}
