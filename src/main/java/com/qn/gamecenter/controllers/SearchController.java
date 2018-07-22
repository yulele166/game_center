package com.qn.gamecenter.controllers;

import net.paoding.rose.web.Invocation;
import net.paoding.rose.web.annotation.Path;
import net.paoding.rose.web.annotation.rest.Get;

import org.springframework.beans.factory.annotation.Autowired;

import com.qn.gamecenter.bean.message.rep.CategoryAppListRep;
import com.qn.gamecenter.bean.message.rep.SuggestWordRep;
import com.qn.gamecenter.bean.message.req.GetSearchResult;
import com.qn.gamecenter.bean.message.req.GetSuggestWordReq;
import com.qn.gamecenter.service.SearchService;

/**
 * @user 
 * @date 2016年6月11日
 */
@Path("/search")
public class SearchController {
	@Autowired
	private SearchService searchService;

	@Get("/getSuggestWord")
	public SuggestWordRep suggestWord(GetSuggestWordReq req, Invocation inv) {
		return searchService.getSuggestResult(req.getWord(), inv);
	}

	@Get("/getSearchResult")
	public CategoryAppListRep search(GetSearchResult result, Invocation inv) {
		return searchService.search(result.getWord(), result.getPi(), inv);
	}

	@Get("/getSearchRollWord")
	public SuggestWordRep getRollWord() {
		return searchService.getRollWord();
	}

}
