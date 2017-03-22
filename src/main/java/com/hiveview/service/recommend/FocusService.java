package com.hiveview.service.recommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.AppMapper;
import com.hiveview.dao.recommend.FocusDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.Focus;

@Service
public class FocusService {

	@Autowired
	private FocusDao focusDao;

	@Autowired
	private AppMapper appDao;
	
	/** 添加 **/
	public int save(Focus focus){
		Focus f = focusDao.getById(focus);
		if(f != null){
			return -1;
		}else{
			return focusDao.save(focus);
		}
	}
	
	/** 修改 **/
	public int update(Focus focus){
		return focusDao.update(focus);
	}
	
	/** 删除 **/
	public int delete(Focus focus){
		return focusDao.delete(focus);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Focus focus,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentName",focus.getContentName());
		map.put("contentType",focus.getContentType());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<Focus> rows = focusDao.getList(map);
		scriptPage.setRows(rows);
		int total = focusDao.getCount(focus);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	public ScriptPage getAppListClassify(Integer categoryId,String appName,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("categoryId",categoryId);
		map.put("appName",appName);
		map.put("currentPage",ajaxPage.getSkipNo());
		map.put("pageSize",ajaxPage.getPageSize());
		scriptPage.setRows(appDao.getAppListClassify(map));
		scriptPage.setTotal(appDao.getAppListClassifyCount(map));
		return scriptPage;
	}
}
