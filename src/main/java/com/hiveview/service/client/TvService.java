package com.hiveview.service.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.client.TvDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.bo.client.CpChannelTvBo;
import com.hiveview.entity.client.Tv;

@Service
public class TvService {
	
	@Autowired
	private TvDao tvDao;
	
	/** 添加 **/
	public int save(Tv tv){
		return tvDao.save(tv);
	}
	
	/** 修改 **/
	public int update(Tv tv){
		return tvDao.update(tv);
	}
	
	/** 删除 **/
	public int delete(Tv tv){
		return tvDao.delete(tv);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Tv tv,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		tv.setPageIndex(ajaxPage.getSkipNo());
		tv.setPageSize(ajaxPage.getPageSize());
		List<Tv> rows = tvDao.getList(tv);
		scriptPage.setRows(rows);
		int total = tvDao.getCount(tv);
		scriptPage.setTotal(total);
		return scriptPage;
	}
	/**
	 * 查询未与当前渠道关联的电视台列表
	 * @param tv
	 * @param ajaxPage
	 * @return
	 */
	public ScriptPage getUnselectList(CpChannelTvBo tvBo,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		tvBo.setPageIndex(ajaxPage.getSkipNo());
		tvBo.setPageSize(ajaxPage.getPageSize());
		List<Tv> rows = tvDao.getUnselectList(tvBo);
		scriptPage.setRows(rows);
		int total = tvDao.getUnselectCount(tvBo);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
