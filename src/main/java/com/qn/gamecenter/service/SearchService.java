package com.qn.gamecenter.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import com.qn.gamecenter.bean.*;
import com.qn.gamecenter.bean.db.SubjectElement;
import com.qn.gamecenter.dao.SuggestWordEleDAO;
import net.paoding.rose.web.Invocation;

import org.apache.commons.lang.StringUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpClientUtil;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.peanut.commons.utils.CollectionUtil;
import com.peanut.commons.utils.DateUtil;
import com.qn.gamecenter.bean.message.rep.CategoryAppListRep;
import com.qn.gamecenter.bean.message.rep.SuggestWordRep;
import com.qn.gamecenter.bean.message.rep.resource.ElementRep;
import com.qn.gamecenter.bean.message.rep.resource.ShortAppInfoRep;
import com.qn.gamecenter.dao.SearchRollWordDAO;

/**
 * 搜索相关服务
 * 
 * @user 
 * @date 2016年6月11日
 */
@Service
public class SearchService {

	@Autowired
	private SearchRollWordDAO rollWordDAO;

	@Autowired
	private AppInfoService appInfoService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private SharePageService sharePageService;

	@Autowired
	private HotWordService hotWordService;

	@Autowired
	private FilterWordService filterWordService;

	@Autowired
	private MessageService messageService;

	@Autowired
	private RedisService redisService;

    @Autowired
    private SuggestWordEleDAO suggestWordEleDAO;

	@Autowired
	private ServerConfig serverConfig;

	private Logger LOG = LoggerFactory.getLogger(SearchService.class);

	/**
	 * 获取推荐词
	 * 
	 * @param word
	 * @return
	 */
	public SuggestWordRep getSuggestResult(String word, Invocation inv) {
		SuggestWordRep rep = new SuggestWordRep();

		// 敏感词
		if (filterWordService.isContentKeyWords(word)) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.KEY_WORD);
			return rep;
		}
		try {
			SolrDocumentList solrDocumentList = getSolrDocumentList(
					Constant.SUGGEST_NAME, word + "*", 0);
			List<String> names = getSuggestName(solrDocumentList,
					Constant.SUGGEST_NAME);

            //处理搜索词重复出现问题
            ShortAppInfoRep shortAppInfoRep = appInfoService.getShortAppInfo(word);
            if (shortAppInfoRep != null) {
                names.remove(word);
            }
            rep.setWords(names);

            List<ElementRep> apps = getSuggestApps(word);
            rep.setEles(apps);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rep;
	}

    /**
	 * 
	 * 获取推荐词相关联的资源信息
	 * @param word
	 * @return
	 */
	public  List<ElementRep> getSuggestApps(String word){
        LOG.info("get suggestApps by word={}", word);
        List<ElementRep> apps;
        //先从redis取出缓存
        Object appsRedis = redisService.getHashObjectValue(RedisKey.SUGGESTWORD_ELEMENT, word);
        if (appsRedis != null) {
            apps = (List<ElementRep>) appsRedis;
            return apps;
        } else {
            apps = CollectionUtil.arrayList();
            Integer suggestWordId = suggestWordEleDAO.getSuggestWordIdByName(word);
            if (suggestWordId != null) {
                List<SubjectElement> swSubjectEles = suggestWordEleDAO.getElementByIdFirst(suggestWordId);
                for (SubjectElement subjectElement : swSubjectEles) {
                    //直接获取推荐词配置的资源信息
                    ElementRep suggestWordResource = subjectService.getElementRep(subjectElement);
                    apps.add(suggestWordResource);
                }
            } else {
                //通过推荐词获取软件信息
                ShortAppInfoRep shortAppInfoRep = appInfoService.getShortAppInfo(word);
                if (shortAppInfoRep != null) {
                    apps.add(shortAppInfoRep);
                }
            }

            //保存到缓存中
            if (!apps.isEmpty()) {
                redisService.addHashObjectValue(RedisKey.SUGGESTWORD_ELEMENT, word, apps);
            }
        }
		return apps;
	}

	/**
	 * 搜索主入口
	 * 
	 * @param word
	 * @param pi
	 * @return
	 */
	public CategoryAppListRep search(String word, int pi, Invocation inv) {
		// 添加搜索次数
		addSearchTimes(word);
		CategoryAppListRep rep = new CategoryAppListRep();
		// 敏感词
		if (filterWordService.isContentKeyWords(word)) {
			messageService.getRepMessage(inv).setStatus(
					ErrorCodeConstant.KEY_WORD);
			return rep;
		}
		List<ShortAppInfoRep> apps = CollectionUtil.arrayList();
		try {
			int start = sharePageService.getStart(pi, Constant.rows);
			SolrDocumentList solrDocumentList = getSolrDocumentList(
					Constant.APP_NAME, word, start);
			List<String> ids = getSuggestName(solrDocumentList, Constant.APP_ID);
			long totalNum = getResultNum(solrDocumentList);
			for (String id : ids) {
				ShortAppInfoRep app = appInfoService.getShortAppInfo(Integer
						.parseInt(id));
				apps.add(app);
			}
			rep.setApps(buildApps(word, apps, pi));
			sharePageService.buildSharePage(rep, pi, Constant.rows, totalNum);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return rep;
	}

	/**
	 * 构建搜索结果集
	 * 
	 * @return
	 */
	private List<ShortAppInfoRep> buildApps(String word,
			List<ShortAppInfoRep> searchResults, int pi) {
		// 检测搜索热词是否有相关联的app
		List<ShortAppInfoRep> withApps = hotWordService.getApps(word);
		// 检测是否有相同的app
		searchResults.removeAll(withApps);
		// 只有第一页匹配
		if (pi == 1) {
			for (int i = 0; i < searchResults.size(); i++) {
				withApps.add(searchResults.get(i));
			}
			return withApps;
		} else {
			return searchResults;
		}
	}

	/**
	 * 根据关键词 获取结果集
	 * 
	 * @param searchKey
	 *            索引key
	 * @param word
	 *            关键词
	 * @param start
	 *            开始位置
	 * @param rows
	 *            获取数量
	 * @return
	 */
	private SolrDocumentList getResult(String searchKey, String word,
			int start, int rows) {
		//solr账号配置处理
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set(HttpClientUtil.PROP_FOLLOW_REDIRECTS, false);
		params.set(HttpClientUtil.PROP_BASIC_AUTH_USER, serverConfig.getSolrUserName());
		params.set(HttpClientUtil.PROP_BASIC_AUTH_PASS, serverConfig.getSolrPassWord());
		params.set(HttpClientUtil.PROP_MAX_CONNECTIONS, 1000);
		params.set(HttpClientUtil.PROP_ALLOW_COMPRESSION, true);
		params.set(HttpClientUtil.PROP_MAX_CONNECTIONS_PER_HOST, 1000);
		CloseableHttpClient closeableHttpClient = HttpClientUtil.createClient(params);
		HttpSolrClient client = new HttpSolrClient(Constant.SOLR_URL, closeableHttpClient);
//		HttpSolrClient client = new HttpSolrClient(Constant.SOLR_URL);
		SolrDocumentList solrList = null;
		try {
			SolrQuery solrQuery = new SolrQuery(searchKey + SolrConstant.SEP
					+ word);
			solrQuery.add("start", start + "");
			solrQuery.add("rows", rows + "");
			QueryResponse resp = client.query(solrQuery);
			solrList = resp.getResults();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return solrList;
	}

	/***
	 * 获取推荐名称
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public List<String> getSuggestName(SolrDocumentList solrResult,
			String getName) throws UnsupportedEncodingException {

		List<String> names = CollectionUtil.arrayList();
		for (int i = 0; i < solrResult.size(); i++) {
			String name = (String) solrResult.get(i).get(getName);
			names.add(name);
		}
		return names;
	}

	/**
	 * 获取搜索结果数量
	 * 
	 * @param solrDocumentList
	 * @return
	 */
	private long getResultNum(SolrDocumentList solrDocumentList) {
		return solrDocumentList.getNumFound();
	}

	/**
	 * 获取搜索结果
	 * 
	 * @param searchKey
	 * @param word
	 * @param pi
	 * @return
	 */
	private SolrDocumentList getSolrDocumentList(String searchKey, String word,
			int start) {
		SolrDocumentList solrResult = getResult(searchKey, word, start,
				Constant.rows);
		return solrResult;
	}

	/**
	 * 获取搜索框的轮播热词
	 * 
	 * @return
	 */
	public SuggestWordRep getRollWord() {
		SuggestWordRep word = new SuggestWordRep();
		word.setWords(rollWordDAO.getWords());
		return word;
	}

	/**
	 * 增加搜索热词的次数
	 * 
	 * @param word
	 */
	public void addSearchTimes(String word) {
		try {
			// 过滤一些无用热词
			if (StringUtils.isBlank(word)) {
				return;
			}
			if (word.length() <= 1) {
				return;
			}
			redisService.increHashValue(getTodaySearchKey(), word);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("add search times error : {}", word);
		}
	}

	/**
	 * 获取当天的搜索热词key
	 * 
	 * @return
	 */
	public String getTodaySearchKey() {
		int date = DateUtil.getTodayDate();
		return RedisKey.SEARCH_WORD_TIMES + date;
	}
}
