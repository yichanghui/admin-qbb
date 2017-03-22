package com.hiveview.dao.cache;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.cache.CacheUrl;

public interface CacheUrlDao extends BaseDao<CacheUrl>{
	
	List<CacheUrl> getList(Map map);
	Integer getCount(Map map);
}
