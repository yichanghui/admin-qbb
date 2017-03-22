package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.ModuleSkin;

public interface ModuleSkinDao extends BaseDao<ModuleSkin>{
	public List<ModuleSkin> getList(Map<String,Object> map);
	public int getCount(Map<String,Object> map);
}
