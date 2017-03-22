package com.hiveview.service.recommend;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.recommend.ModuleSkinDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.ModuleSkin;

@Service
public class ModuleSkinService {
	
	@Autowired
	private ModuleSkinDao moduleSkinDao;
	
	/** 添加 **/
	public int save(ModuleSkin backgroundrecom){
		return moduleSkinDao.save(backgroundrecom);
	}
	
	/** 修改 **/
	public int update(ModuleSkin backgroundrecom){
		return moduleSkinDao.update(backgroundrecom);
	}
	
	/** 删除 **/
	public int delete(ModuleSkin backgroundrecom){
		return moduleSkinDao.delete(backgroundrecom);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(ModuleSkin backgroundrecom,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("backgroundRecom",backgroundrecom);
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<ModuleSkin> rows = moduleSkinDao.getList(map);
		scriptPage.setRows(rows);
		int total = moduleSkinDao.getCount(map);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
