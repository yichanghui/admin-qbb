package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.HdFocus;

public interface HdFocusDao extends BaseDao<HdFocus>{
	
	public List<HdFocus> getList(Map<String,Object> map);
	
	public Integer getCount(HdFocus hdFocus);
	
	/**
	 * 根据contentid contentType 判断数据是否已经存在
	 * @param hdFocus
	 * @return
	 */
	HdFocus getById(HdFocus hdFocus);
}
