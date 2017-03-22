package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.Subject;

public interface SubjectDao extends BaseDao<Subject>{
	
	public List<Subject> getList(Map<String,Object> map);
	
	public Integer getCount(Map map);
}
