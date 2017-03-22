package com.hiveview.service.app.app;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.app.SearchAppDao;
import com.hiveview.entity.app.app.SearchApp;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.util.DateUtil;

@Service
public class SearchAppService {
	
	@Autowired
	private SearchAppDao searchAppDao;
	
	/** 添加 **/
	public int save(SearchApp searchapp){
		if(this.getEntityByObj(searchapp))
			return -100;
		searchapp.setUpdateTime(DateUtil.getTimeStamp(new Date()));
		return searchAppDao.save(searchapp);
	}
	
	/** 修改 **/
	public int update(SearchApp searchapp,boolean flagNoUpdateCurrnetData){
		if(this.getEntityByObj(searchapp)&&flagNoUpdateCurrnetData)
			return -100;
		return searchAppDao.update(searchapp);
	}
	
	/** 删除 **/
	public int delete(SearchApp searchapp){
		return searchAppDao.delete(searchapp);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(SearchApp searchapp,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("appType",searchapp.getAppType());
		map.put("appName",searchapp.getAppName());
		map.put("categoryId",searchapp.getCategoryId());
		map.put("isEffective",searchapp.getIsEffective());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<SearchApp> rows = searchAppDao.getList(map);
		scriptPage.setRows(rows);
		int total = searchAppDao.count(searchapp);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	
	private boolean getEntityByObj(SearchApp searchapp){
		searchapp=searchAppDao.get(searchapp);
		if(searchapp!=null)
			return true;
		return false;
	}
}
