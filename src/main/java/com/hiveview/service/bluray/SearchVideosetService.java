package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.SearchVideosetDao;
import com.hiveview.entity.bluray.SearchVideoset;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class SearchVideosetService {
	
	@Autowired
	private SearchVideosetDao searchVideosetDao;
	
	/** 添加 **/
	public int save(SearchVideoset searchvideoset){
		SearchVideoset sv = searchVideosetDao.get(searchvideoset);
		if(sv == null){
			return searchVideosetDao.save(searchvideoset);
		}else{
			return 0;
		}
	}
	
	/** 修改 **/
	public int update(SearchVideoset searchvideoset){
		return searchVideosetDao.update(searchvideoset);
	}
	
	/** 删除 **/
	public int delete(SearchVideoset searchvideoset){
		return searchVideosetDao.delete(searchvideoset);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(SearchVideoset searchvideoset,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<SearchVideoset> rows = searchVideosetDao.getSearchList(map);
		scriptPage.setRows(rows);
		int total = searchVideosetDao.getCount(map);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
