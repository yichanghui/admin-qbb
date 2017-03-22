package com.hiveview.service.app.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.app.AppSubjectDao;
import com.hiveview.entity.app.app.AppSubject;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class AppSubjectService {
	
	@Autowired
	private AppSubjectDao appSubjectDao;
	
	/** 添加 **/
	public int save(AppSubject appsubject){
		return appSubjectDao.save(appsubject);
	}
	
	/** 修改 **/
	public int update(AppSubject appsubject){
		return appSubjectDao.update(appsubject);
	}
	
	/** 删除 **/
	public int delete(AppSubject appsubject){
		return appSubjectDao.delete(appsubject);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(AppSubject appsubject,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		appsubject.setPageIndex(ajaxPage.getSkipNo());
		appsubject.setPageSize(ajaxPage.getPageSize());
		List<AppSubject> rows = appSubjectDao.getList(appsubject);
		scriptPage.setRows(rows);
		int total = appSubjectDao.getCount(appsubject);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
