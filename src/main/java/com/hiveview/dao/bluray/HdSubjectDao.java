package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.HdSubject;

public interface HdSubjectDao extends BaseDao<HdSubject>{
	
	public List<HdSubject> getList(Map<String,Object> map);
	
	public Integer getCount(HdSubject hdsubject);
}
