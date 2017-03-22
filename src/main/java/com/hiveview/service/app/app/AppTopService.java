package com.hiveview.service.app.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.app.AppTopDao;
import com.hiveview.entity.app.app.AppTop;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.app.AppTopVo;

@Service
public class AppTopService {
	
	@Autowired
	private AppTopDao appTopDao;
	
	/** 添加 **/
	public int save(AppTop apptop){
		return appTopDao.save(apptop);
	}
	
	/** 修改 **/
	public int update(AppTop apptop){
		return appTopDao.update(apptop);
	}
	
	/** 删除 **/
	public int delete(AppTop apptop){
		return appTopDao.delete(apptop);
	}
	
	/**
	 * 查询app_top表信息
	 * @param apptop
	 * @param ajaxPage
	 * @return
	 */
	public ScriptPage getList(AppTop apptop,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		apptop.setPageIndex(ajaxPage.getSkipNo());
		apptop.setPageSize(ajaxPage.getPageSize());
		List<AppTop> rows = appTopDao.getList(apptop);
		scriptPage.setRows(rows);
		int total = appTopDao.getCount(apptop);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	/**
	 * 查询榜单列表详细信息
	 * @param apptop
	 * @param ajaxPage
	 * @return
	 */
	public ScriptPage getAppTopList(AppTop apptop,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		apptop.setPageIndex(ajaxPage.getSkipNo());
		apptop.setPageSize(ajaxPage.getPageSize());
		List<AppTopVo> rows = appTopDao.getAppTopList(apptop);
		scriptPage.setRows(rows);
		int total = appTopDao.getCount(apptop);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
