package com.qn.gamecenter.service;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import com.qn.gamecenter.bean.search.AppInfo;

/**
 * @user 
 * @date 2016年6月7日
 */
public class SolrJTest {
	public static String SOLR_URL = "http://103.231.66.24/solr/game_center/";

	public static void main(String[] args) throws SolrServerException,
			IOException {
		HttpSolrClient client = new HttpSolrClient(SOLR_URL);
		
		SolrQuery solrQuery = new SolrQuery("appName:战");
//		solrQuery.add("start", "10");
//		solrQuery.add("rows","20");
		QueryResponse resp = client.query(solrQuery);
		client.close();
	//	{responseHeader={status=0,QTime=1,params={q=suggestName:战机*,wt=javabin,version=2}},response={numFound=7,start=0,docs=[SolrDocument{suggestName=战机轰炸, appName=[战机轰炸], id=1075336, icon=http://nimg.52fengyou.cn/pic/plat/5/1/50153_sicon.png, _version_=1536487289624985619}, SolrDocument{suggestName=战机怒火, appName=[战机怒火], id=202039, icon=http://p5.qhimg.com/t010dd0770ce671f8a3.png, _version_=1536487290010861573}, SolrDocument{suggestName=战机猜猜猜, appName=[战机猜猜猜], id=1071805, icon=http://nimg.52fengyou.cn/pic/plat/3/2/30271_sicon.png, _version_=1536487290207993864}, SolrDocument{suggestName=战机大拼图, appName=[战机大拼图], id=1077134, icon=http://nimg.52fengyou.cn/pic/plat/6/1/60163_sicon.png, _version_=1536487290261471233}, SolrDocument{suggestName=战机着陆 Historical Landings, appName=[战机着陆 Historical Landings], id=1127921, icon=http://fapk.52fengyou.cn/pic/plat/7/4/70441_sicon.png, _version_=1536487290300268554}, SolrDocument{suggestName=战机险情十面埋伏 FighterDangerGame, appName=[战机险情十面埋伏 FighterDangerGame], id=480956, icon=http://pp.myapp.com/ma_icon/0/icon_88155_688745_1415094060/96, _version_=1536487290641055746}, SolrDocument{suggestName=战机X雷电, appName=[战机X雷电], id=572265, icon=http://pp.myapp.com/ma_icon/0/icon_10701646_18332428_1415661075/96, _version_=1536487291772469285}]}}
		SolrDocumentList solrList = resp.getResults();
		System.out.println(solrList.getNumFound());
		for (int i = 0; i < solrList.size(); i++) {
			System.out.println(solrList.get(i));
		}
	
	}
}
