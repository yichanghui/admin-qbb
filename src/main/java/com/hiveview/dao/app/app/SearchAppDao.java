package com.hiveview.dao.app.app;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.app.app.SearchApp;

public interface SearchAppDao extends BaseDao<SearchApp>{
	public List<SearchApp> getList(Map<String, Object> map);
}
