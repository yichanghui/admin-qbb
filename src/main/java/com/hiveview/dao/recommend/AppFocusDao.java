package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.AppFocus;

public interface AppFocusDao extends BaseDao<AppFocus>{
	public List<AppFocus> getList(Map<String,Object> map);
}
