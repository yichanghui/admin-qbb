package com.hiveview.service.app;

import com.hiveview.dao.app.AppVersionImgDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.app.AppVersionsImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppVersionImgService {
	
	@Autowired
	private AppVersionImgDao appVersionImgDao;
	
	/** 添加 **/
	public int save(AppVersionsImg appversionimg){
		return appVersionImgDao.save(appversionimg);
	}
	
	/** 修改 **/
	public int update(AppVersionsImg appversionimg){
		return appVersionImgDao.update(appversionimg);
	}
	
	/** 删除 **/
	public int delete(AppVersionsImg appversionimg){
		return appVersionImgDao.delete(appversionimg);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(AppVersionsImg appversionimg, AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		appversionimg.setPageIndex(ajaxPage.getSkipNo());
		appversionimg.setPageSize(ajaxPage.getPageSize());
		List<AppVersionsImg> rows = appVersionImgDao.getList(appversionimg);
		scriptPage.setRows(rows);
		int total = appVersionImgDao.getCount(appversionimg);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
