package com.qn.gamecenter.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @user 
 * @date 2016年6月21日
 */
@Component
public class ServerConfig {
	@Value("#{propertyConfigurer['server.cacheOpen']}")
	private boolean cacheOpen;

	@Value("#{propertyConfigurer['server.future']}")
	private boolean future;
	
	@Value("#{propertyConfigurer['solr.username']}")
	private String solrUserName;
	@Value("#{propertyConfigurer['solr.password']}")
	private String solrPassWord;


	public boolean isCacheOpen() {
		return cacheOpen;
	}

	public void setCacheOpen(boolean cacheOpen) {
		this.cacheOpen = cacheOpen;
	}

	public String getSolrUserName() {
		return solrUserName;
	}

	public void setSolrUserName(String solrUserName) {
		this.solrUserName = solrUserName;
	}

	public String getSolrPassWord() {
		return solrPassWord;
	}

	public void setSolrPassWord(String solrPassWord) {
		this.solrPassWord = solrPassWord;
	}

	public boolean isFuture() {
		return future;
	}

	public void setFuture(boolean future) {
		this.future = future;
	}
	
	
}
