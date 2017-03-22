package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.Cast;

public interface CastDao extends BaseDao<Cast>{
	
	public List<Cast> getList(Map<String,Object> map);
	
	public Integer getCount(Cast cast);
}
