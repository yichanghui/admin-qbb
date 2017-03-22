package com.hiveview.service.video;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hiveview.common.Constants;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.util.HttpUtil;

@Service
public class FilmReviewService {
	
	public ScriptPage getFileReview(String filmName,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		String videoJsonStr = HttpUtil.reqGet(MessageFormat.format(Constants.DB_MOVE_SEARCH_URL,filmName,ajaxPage.getSkipNo(),ajaxPage.getPageSize()));
		JSONObject videoJson = JSONObject.parseObject(videoJsonStr);
		scriptPage.setTotal(videoJson.getInteger("total"));
		if(videoJson.containsKey("subjects")){
			List<JSONObject> rows = (List<JSONObject>) videoJson.get("subjects");
			scriptPage.setRows(rows);
		}
		return scriptPage;
	}
//	public static void main(String[] args) {
//		FilmReviewFetch ser = new FilmReviewFetch();
//		AjaxPage ajaxPage = new AjaxPage();
//		ser.getFileReview("神探狄仁杰",ajaxPage);
//	}
}
