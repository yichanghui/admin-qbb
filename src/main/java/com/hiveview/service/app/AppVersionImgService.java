package com.hiveview.service.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.AppVersionImgDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.app.AppVersionImg;

@Service
public class AppVersionImgService {
	
	@Autowired
	private AppVersionImgDao appVersionImgDao;
	
	/** 添加 **/
	public int save(AppVersionImg appversionimg){
		return appVersionImgDao.save(appversionimg);
	}
	
	/** 修改 **/
	public int update(AppVersionImg appversionimg){
		return appVersionImgDao.update(appversionimg);
	}
	
	/** 删除 **/
	public int delete(AppVersionImg appversionimg){
		return appVersionImgDao.delete(appversionimg);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(AppVersionImg appversionimg,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		appversionimg.setPageIndex(ajaxPage.getSkipNo());
		appversionimg.setPageSize(ajaxPage.getPageSize());
		List<AppVersionImg> rows = appVersionImgDao.getList(appversionimg);
		scriptPage.setRows(rows);
		int total = appVersionImgDao.getCount(appversionimg);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
