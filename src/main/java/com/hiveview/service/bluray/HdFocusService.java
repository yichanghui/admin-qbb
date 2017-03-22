package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.HdFocusDao;
import com.hiveview.entity.bluray.HdFocus;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class HdFocusService {
	
	@Autowired
	private HdFocusDao hdFocusDao;
	
	/** 添加 **/
	public int save(HdFocus hdfocus){
		HdFocus focus = hdFocusDao.getById(hdfocus);
		if(focus != null){
			return -1;
		}else{
			return hdFocusDao.save(hdfocus);
		}
	}
	
	/** 修改 **/
	public int update(HdFocus hdfocus){
		return hdFocusDao.update(hdfocus);
	}
	
	/** 删除 **/
	public int delete(HdFocus hdfocus){
		return hdFocusDao.delete(hdfocus);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(HdFocus hdfocus,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentName",hdfocus.getContentName());
		map.put("contentType",hdfocus.getContentType());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<HdFocus> rows = hdFocusDao.getList(map);
		scriptPage.setRows(rows);
		int total = hdFocusDao.getCount(hdfocus);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
