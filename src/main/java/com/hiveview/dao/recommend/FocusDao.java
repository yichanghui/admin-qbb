package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.Focus;

public interface FocusDao extends BaseDao<Focus>{
	
	public List<Focus> getList(Map<String,Object> map);
	
	public Integer getCount(Focus focus);
	
	/**
	 * 根据contentid contentType 判断数据是否已经存在
	 * @param hdFocus
	 * @return
	 */
	Focus getById(Focus focus);
}
