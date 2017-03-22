package com.hiveview.dao.video;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.video.VideosetCast;

public interface VideosetCastDao extends BaseDao<VideosetCast>{
	
	public List<VideosetCast> getList(Map<String,Object> map);
	
	public Integer getCount(VideosetCast videosetcast);
}
