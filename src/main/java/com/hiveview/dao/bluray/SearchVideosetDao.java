package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.SearchVideoset;

public interface SearchVideosetDao extends BaseDao<SearchVideoset>{
	
	public List<SearchVideoset> getSearchList(Map<String,Object> map);
	
	public Integer getCount(Map map);
}
