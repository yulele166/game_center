package com.qn.gamecenter.service;

import java.util.List;

import com.qn.gamecenter.bean.message.req.GetShareInfoReq;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.bean.Constant;
import com.qn.gamecenter.bean.ErrorCodeConstant;
import com.qn.gamecenter.bean.OpenType;
import com.qn.gamecenter.bean.RedisKey;
import com.qn.gamecenter.bean.RequestMessage;
import com.qn.gamecenter.bean.ShowType;
import com.qn.gamecenter.bean.db.SubjectElement;
import com.qn.gamecenter.bean.db.TabPage;
import com.qn.gamecenter.bean.message.rep.AppContentRep;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.HtmlPageRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.bean.message.rep.resource.SubJect;
import com.qn.gamecenter.dao.HotWordDAO;
import com.qn.gamecenter.dao.SubjectBrowTimeDAO;
import com.qn.gamecenter.dao.SubjectDAO;
import com.qn.gamecenter.dao.SubjectEleDAO;

import net.paoding.rose.web.Invocation;

/**
 * 专题相关服务
 * 
 * @user 
 * @date 2016年6月14日
 */
@Service
public class SubjectService {
	@Autowired
	private SubjectEleDAO eleDAO;

	@Autowired
	private SubjectDAO subjectDAO;

	@Autowired
	private HotWordDAO hotWordDAO;

	@Autowired
	private HtmlPageService htmlPageService;

	@Autowired
	private AppInfoService appInfoService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private GiftService giftService;

	@Autowired
	private SharePageService sharePageService;

	@Autowired
	private ScheduleService scheduleService;

	@Autowired
	private SubjectBrowTimeDAO browTimeDAO;

	@Autowired
	private ShowTypeService showTypeService;

	@Autowired
	private RedisCacheService redisCacheService;

	@Autowired
	private RedisService redisService;
	
	@Autowired
	private MessageService messageService;

	/**
	 * 分页获取某一专题内容
	 * 
	 * @param start
	 * @param end
	 * @param id
	 * @return
	 */
	public List<ElementRep> getSubjectById(int id, int start, int end) {
		// 获取专题内的列表信息
		List<SubjectElement> eles = eleDAO.getElementById(id, start, end);
		List<ElementRep> eleReps = CollectionUtil.arrayList();
		ElementRep eleRep;
		for (SubjectElement ele : eles) {
			eleRep = getElementRep(ele);
			eleReps.add(eleRep);
		}
		return eleReps;
	}

	/**
	 * 获取某一专题内容
	 * 
	 * @param id
	 * @return
	 */
	public List<ElementRep> getSubjectById(int id) {
		// 获取专题内的列表信息
		List<SubjectElement> eles = eleDAO.getElementById(id);
		List<ElementRep> eleReps = CollectionUtil.arrayList();
		ElementRep eleRep;
		// 获取专题内的元素详情
		for (SubjectElement ele : eles) {
			eleRep = getElementRep(ele);
			eleReps.add(eleRep);
		}
		return eleReps;
	}

	/**
	 * 分页获取带有内容详情的专题
	 * 
	 * @param id
	 * @param start
	 * @param end
	 * @return
	 */
	public SubJect getSubjectWithContent(int id, int start, int end) {
		SubJect subJect = subjectDAO.getSubject(id);
		List<ElementRep> eles = getSubjectById(id, start, end);
		subJect.setEles(eles);
		return subJect;
	}

	/**
	 * 获取带有内容详情的专题
	 * 
	 * @param id
	 * @return
	 */
	public SubJect getSubjectWithContent(int id) {
		SubJect subJect = subjectDAO.getSubject(id);
		List<ElementRep> eles = getSubjectById(id);
		subJect.setEles(eles);
		return subJect;
	}

	/**
     * 热词，精品页头图缓存处理
     * @author mayihu
     */
    public SubJect getSubjectWithContentCache(int id) {
        //检测缓存中是否存在
        SubJect subJect = getSubJectFromCache(id, Constant.SUBJECT_CACHE_PI);
        if (subJect != null) {
            return subJect;
        }
        subJect = subjectDAO.getSubject(id);
        List<ElementRep> eles = getSubjectById(id);
        subJect.setEles(eles);
        saveSubject(subJect, Constant.SUBJECT_CACHE_PI);
        return subJect;
    }

    /**
     * 分页获取带有内容详情的专题
	 * 
	 * @param id
	 * @return
	 */
	public SubJect getSubjectWithSharePage(int id, int pi) {
		// 检测缓存中是否有
		SubJect subJect = getSubJectFromCache(id, pi);
        if (subJect != null) {
            int times = getOpenSubjectTimes(id);
            subJect.setBrowTimes(times);
			return subJect;
		}
		int start = sharePageService
				.getStart(pi, Constant.SUBJECT_CONTENT_SIZE);
		int end = sharePageService.getEnd(pi, Constant.SUBJECT_CONTENT_SIZE);
		int totalNum = eleDAO.getSubjectEleNum(id);
		subJect = subjectDAO.getSubject(id);

		List<ElementRep> eles = getSubjectById(id, start, end);
		subJect.setEles(eles);
		sharePageService.buildSharePage(subJect, pi,
				Constant.SUBJECT_CONTENT_SIZE, totalNum);
		saveSubject(subJect, pi);
		return subJect;
	}

	/**
	 * 获取发现页面的内容
	 * 
	 * @return
	 */
	public SubJect getDiscoveryPage(int pi, int appVersion) {
		// 获取发现页面的排期专题id
		int subjectId = scheduleService.getDiscoveryPageId(appVersion);
		return getSubjectWithSharePage(subjectId, pi);
	}

    /**
     * 获取发现页面二中的内容
     *
     * @param pi
     * @return
     */
    public SubJect getDiscoverySecondPage(int pi) {
		Integer subjectId = scheduleService.getDiscoverySecondPageId();
		return getSubjectWithSharePage(subjectId, pi);
	}

	/**
	 * 获取搜索页面中的热词信息
	 * 
	 * @return
	 */
	public SubJect getSearchSubject() {
		int subjectId = scheduleService.getSearchPageId();
        return getSubjectWithContentCache(subjectId);
    }

	/**
	 * 获取精品页头图
	 * 
	 * @return
	 */
	public SubJect getQualityPageTitle(int startTimes) {
		
		int subjectId = scheduleService.getQualityPageTitle(startTimes);
        return getSubjectWithContentCache(subjectId);
    }

	/**
	 * 构建
	 * 
	 * @param element
	 * @return
	 */
	public ElementRep getElementRep(SubjectElement element) {
		int openType = element.getOpenType();
		int eleId = element.getElementId();
		int sort = element.getSort();
		int showType = element.getShowType();
		String showDesc = element.getShowDesc();
		ElementRep ele = getElementRep(eleId, openType, sort, showType);
		// 如果展示文本不为空 则 替换元素中的shortdesc
		if (StringUtils.isNotBlank(showDesc)) {
			ele.setShortDesc(showDesc);
		}
 		// 如果是软件信息 构建软件标签
		if (openType == OpenType.OPEN_APP_INFO_PAGE
				&& element.getImgType() != 0) {
			ShortAppInfoRep app = (ShortAppInfoRep) ele;
			appInfoService.buildAppTag(app, element.getImgType(),
					element.getAnimationType(), element.getTagWord());
		}
		return ele;
	}

	/**
	 * 获取对应元素
	 * 
	 * @param eleId
	 * @param openType
	 * @param sort
	 * @param needShow
	 *            是否需要展开专题
	 * @return
	 */
	public ElementRep getElementRep(int eleId, int openType, int sort,
			int showType) {
		ElementRep ele;
		switch (openType) {
		case OpenType.OPEN_APP_INFO_PAGE:
			// 软件详情页
			ele = appInfoService.getShortAppInfo(eleId);
			ele.setShowType(showType);
			ShortAppInfoRep app = (ShortAppInfoRep) ele;
			// appInfoService.buildAppTag(app, , animationType, word);
			buildAppContent(showType, app, eleId);
			break;
		case OpenType.OPEN_HTML_PAGE:
			// html页面
			ele = htmlPageService.getHtml(eleId);
			ele.setShowType(showType);
			break;
		case OpenType.OPEN_SUBJECT_PAGE:
			ele = getSubjectWithShowType(eleId, showType);
			break;
		case OpenType.OPEN_CATEGORY_PAGE:
			ele = categoryService.getCategory(eleId);
			ele.setShowType(showType);
			break;
		case OpenType.OPEN_SEARCH_PAGE:
			ele = hotWordDAO.getHotWord(eleId);
			ele.setShowType(showType);
			break;
		case OpenType.OPEN_GIFT_PAGE:
			ele = appInfoService.getShortAppInfo(eleId);
			ele.setShowType(showType);
			int num = giftService.getGiftNum(eleId);
			ShortAppInfoRep shortApp = (ShortAppInfoRep) ele;
			shortApp.setGiftNum(num);
			break;

		case OpenType.OPEN_GIFT_SUBJECT:
			ele = getSubjectWithShowType(eleId, showType);
			break;
		default:
			ele = new ElementRep();
			break;
		}
		ele.setOpenType(openType);
		ele.setSort(sort);
		return ele;
	}

	/**
	 * 根据展示类型获取专题
	 * 
	 * @param eleId
	 * @param showType
	 * @return
	 */
	public ElementRep getSubjectWithShowType(int eleId, int showType) {
		SubJect ele = getSubject(eleId);
		boolean needShow = showTypeService.isNeedShow(ele.getShowType());
		// 专题资源
		if (needShow) {
			ele = getSubjectWithContent(eleId);
		}
		// 获取专题浏览次数
		int browTimes = getOpenSubjectTimes(eleId);
		ele.setBrowTimes(browTimes);
		return ele;
	}

	/**
	 * 分页获取精品页面内容
	 * @param startTimes 启动次数
	 * @return
	 */
	public SubJect getQualityAppPage(int pi,int startTimes) {
		int subjectId = scheduleService.getQualityId(startTimes);
		return getSubjectWithSharePage(subjectId, pi);
	}

	/**
	 * 获取专题简介
	 * 
	 * @param subJectId
	 * @return
	 */
	public SubJect getSubject(int subJectId) {
		return subjectDAO.getSubject(subJectId);
	}

	/**
	 * 根据展现形态构造app
	 * 
	 * @param showType
	 * @param app
	 * @param appId
	 */
	public void buildAppContent(int showType, ShortAppInfoRep app, int appId) {
		switch (showType) {
		case ShowType.APP_LIST_WITH_VIDEO:
			List<HtmlPageRep> htmls = htmlPageService.getVideoPage(appId);
			app.setEles(htmls);
			break;
		case ShowType.APP_LIST_WITH_GIFT:
			int num = giftService.getGiftNum(appId);
			app.setGiftNum(num);
			break;
		case ShowType.APP_WITH_GIFT:
			buildAppContent(appId, app);
			break;
		default:
			break;
		}
	}

	/**
	 * 构建礼包 攻略 活动信息
	 * 
	 * @param appId
	 * @param app
	 */
	public void buildAppContent(int appId, ShortAppInfoRep app) {
		List<AppContentRep> cons = CollectionUtil.arrayList();
		int actPageNum = htmlPageService
				.getTotal(appId, Constant.ACTIVITY_PAGE);
		int tacticPageNum = htmlPageService.getTotal(appId,
				Constant.TACTIC_PAGE);
		int giftNum = giftService.getGiftNum(appId);
		// 获取app下的礼包 攻略 活动 数量
		cons.add(new AppContentRep(giftNum, "礼包", Constant.GIFT));
		cons.add(new AppContentRep(tacticPageNum, "攻略", Constant.TACTIC_PAGE));
		cons.add(new AppContentRep(actPageNum, "活动", Constant.ACTIVITY_PAGE));
		app.setContents(cons);
	}

	/**
	 * 获取tab页面内容
	 * 5.1.0版本以下返回错误码
	 * @return
	 */
	public ElementRep getTab(Invocation inv) {

		ElementRep elementRep = null;
	
		RequestMessage message = (RequestMessage)inv.getAttribute("message");
		
		int appVersion = message.getBaseInfo().getVersionInt();
		
		if (appVersion < Constant.TAB_SHOW_APP_VERSION) {
			messageService.getRepMessage(inv).setStatus(ErrorCodeConstant.NO_TAB);
			return null;
		}

		Object obj = redisService.getObjValue(RedisKey.GET_TAB_PAGE);
		
		if (obj!=null) {
			elementRep = (ElementRep)obj;
		}else {
			TabPage tab = scheduleService.getTabPageSchedule();
			
			if (tab==null) {
				messageService.getRepMessage(inv).setStatus(ErrorCodeConstant.NO_TAB);
				return null;
			}
			elementRep = getElementRep(tab.getElementId(), tab.getOpenType(), 1, ShowType.ACT_TAB);
			elementRep.setImgUrl(tab.getImgUrl());
			elementRep.setName(tab.getName());
			redisService.setObjValue(RedisKey.GET_TAB_PAGE, elementRep);
		}
		
		return elementRep;
		
	}
	

	/**
	 * 保存subject 到缓存
	 * 
	 * @param ele
	 */
	public void saveSubject(SubJect subject, int pi) {
		redisCacheService.setSubject(subject, pi);
	}

	/**
	 * 获取subject
	 * 
	 * @param subId
	 * @param pi
	 * @return
	 */
	public SubJect getSubJectFromCache(int subId, int pi) {
		SubJect subject = redisCacheService.getSubjectBean(subId, pi);
		if (subject != null) {
			List<ElementRep> subjects = subject.getEles();
			ElementRep ele;
			for (int i = 0; i < subjects.size(); i++) {
				ele = subjects.get(i);
				// 需要展示次数的专题
				if (ele.getShowType() == ShowType.SUBJECT_LIST) {
					SubJect sub = (SubJect) ele;
					int times = getOpenSubjectTimes(sub.getId());
					sub.setBrowTimes(times);
				}
			}
		}
		return subject;
	}

	/**
	 * 获取专题的打开次数
	 * 
	 * @param subId
	 * @return
	 */
	public int getOpenSubjectTimes(int subId) {
		if (redisService.existKey(RedisKey.SUBJECT_OPEN_TIMES)) {
			String value = (String) redisService.getHashValue(
					RedisKey.SUBJECT_OPEN_TIMES, subId + "");
			if (StringUtils.isNotBlank(value)) {
				return Integer.parseInt(value);
			}
		}
		return 0;
	}

	/**
	 * 增加专题的浏览次数
	 * 
	 * @param subId
	 */
	public void addOpenSubjectTimes(int subId) {
		redisService.increHashValue(RedisKey.SUBJECT_OPEN_TIMES, subId + "");
	}

}
