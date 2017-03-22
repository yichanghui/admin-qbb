package com.hiveview.dao.video;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.video.VideosetRelated;

public interface VideosetRelatedDao extends BaseDao<VideosetRelated>{
	
	public List<VideosetRelated> getList(Map<String,Object> map);
	
	public Integer getCount(VideosetRelated videosetrelated);
}
