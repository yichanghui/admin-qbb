package com.hiveview.dao.bluray;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.bluray.CastPhotos;

public interface CastPhotosDao extends BaseDao<CastPhotos>{
	
	public List<CastPhotos> getList(Map<String,Object> map);
	
	public Integer getCount(CastPhotos castphotos);
}
