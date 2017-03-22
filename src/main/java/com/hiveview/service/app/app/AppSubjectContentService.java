package com.hiveview.service.app.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.app.AppSubjectContentDao;
import com.hiveview.entity.app.app.AppSubjectContent;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.app.AppSubjectContentVo;

@Service
public class AppSubjectContentService {
	
	@Autowired
	private AppSubjectContentDao appSubjectContentDao;
	
	/** 添加 **/
	public int save(AppSubjectContent appsubjectcontent){
		return appSubjectContentDao.save(appsubjectcontent);
	}
	
	/** 修改 **/
	public int update(AppSubjectContent appsubjectcontent){
		return appSubjectContentDao.update(appsubjectcontent);
	}
	
	/** 删除 **/
	public int delete(AppSubjectContent appsubjectcontent){
		return appSubjectContentDao.delete(appsubjectcontent);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(AppSubjectContent appsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		appsubjectcontent.setPageIndex(ajaxPage.getSkipNo());
		appsubjectcontent.setPageSize(ajaxPage.getPageSize());
		List<AppSubjectContent> rows = appSubjectContentDao.getList(appsubjectcontent);
		scriptPage.setRows(rows);
		int total = appSubjectContentDao.getCount(appsubjectcontent);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	/** 获取列表 **/
	public ScriptPage getInfoList(AppSubjectContent appsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		appsubjectcontent.setPageIndex(ajaxPage.getSkipNo());
		appsubjectcontent.setPageSize(ajaxPage.getPageSize());
		List<AppSubjectContentVo> rows = appSubjectContentDao.getInfoList(appsubjectcontent);
		scriptPage.setRows(rows);
		int total = appSubjectContentDao.getCount(appsubjectcontent);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
