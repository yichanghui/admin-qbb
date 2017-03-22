package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.HdSubjectContent;

public interface HdSubjectContentDao extends BaseDao<HdSubjectContent>{
	
	public List<HdSubjectContent> getList(Map<String,Object> map);
	
	public Integer getCount(HdSubjectContent hdsubjectcontent);
}
