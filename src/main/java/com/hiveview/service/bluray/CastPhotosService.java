package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.CastPhotosDao;
import com.hiveview.entity.bluray.CastPhotos;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;

@Service
public class CastPhotosService {
	
	@Autowired
	private CastPhotosDao castPhotosDao;
	
	/** 添加 **/
	public int save(CastPhotos castphotos){
		return castPhotosDao.save(castphotos);
	}
	
	/** 修改 **/
	public int update(CastPhotos castphotos){
		return castPhotosDao.update(castphotos);
	}
	
	/** 删除 **/
	public int delete(CastPhotos castphotos){
		return castPhotosDao.delete(castphotos);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(CastPhotos castphotos,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("castId",castphotos.getCastId());
		map.put("castType",castphotos.getCastType());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<CastPhotos> rows = castPhotosDao.getList(map);
		scriptPage.setRows(rows);
		int total = castPhotosDao.getCount(castphotos);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
