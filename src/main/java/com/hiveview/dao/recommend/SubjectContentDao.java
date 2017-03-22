package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.SubjectContent;

public interface SubjectContentDao extends BaseDao<SubjectContent>{
	
	public List<SubjectContent> getList(Map<String,Object> map);
	
	public Integer getCount(Map map);
}
