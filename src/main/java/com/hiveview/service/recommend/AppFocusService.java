package com.hiveview.service.recommend;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.recommend.AppFocusDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.AppFocus;
import com.hiveview.util.DateUtil;

@Service
public class AppFocusService {
	
	@Autowired
	private AppFocusDao appFocusDao;
	
	/** 添加 **/
	public int save(AppFocus appfocus){
		if(getEntityByObj(appfocus))//判断数据是否存在
			return -100;
		appfocus.setCreatedTime(DateUtil.getTimeStamp(new Date()));
		appfocus.setUpdatedTime(DateUtil.getTimeStamp(new Date()));
		return appFocusDao.save(appfocus);
	}
	
	/** 修改 **/
	public int update(AppFocus appfocus,boolean flagNoUpdateCurrnetData){
		if(getEntityByObj(appfocus)&&flagNoUpdateCurrnetData)//判断数据是否存在
			return -100;
		appfocus.setUpdatedTime(DateUtil.getTimeStamp(new Date()));
		return appFocusDao.update(appfocus);
	}
	
	/** 删除 **/
	public int delete(AppFocus appfocus){
		return appFocusDao.delete(appfocus);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(AppFocus appfocus,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("navigationId",appfocus.getNavigationId());
		map.put("contentType",appfocus.getContentType());
		map.put("contentName",appfocus.getContentName());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<AppFocus> rows = appFocusDao.getList(map);
		scriptPage.setRows(rows);
		int total = appFocusDao.count(appfocus);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	
	/**
	 * 通过条件查找。方法用来判断前台数据是否有重复
	 * @return
	 */
	private boolean getEntityByObj(AppFocus appfocus){
		AppFocus appFocus = appFocusDao.get(appfocus);
		if(appFocus!=null)
			return true;
		return false;
	}
}
