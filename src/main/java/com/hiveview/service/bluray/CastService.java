package com.hiveview.service.bluray;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.bluray.CastDao;
import com.hiveview.entity.bluray.Cast;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.util.PinyinUtil;

@Service
public class CastService {
	
	@Autowired
	private CastDao castDao;
	
	/** 添加 **/
	public int save(Cast cast){
		cast.setCastPyname(PinyinUtil.getFirstHanyuPinyin(cast.getCastName()));
		return castDao.save(cast);
	}
	
	/** 修改 **/
	public int update(Cast cast){
		cast.setCastPyname(PinyinUtil.getFirstHanyuPinyin(cast.getCastName()));
		return castDao.update(cast);
	}
	
	/** 删除 **/
	public int delete(Cast cast){
		return castDao.delete(cast);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(Cast cast,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("castName",cast.getCastName());
		map.put("castType",cast.getCastType());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<Cast> rows = castDao.getList(map);
		scriptPage.setRows(rows);
		int total = castDao.getCount(cast);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
