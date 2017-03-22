package com.hiveview.dao.recommend;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.recommend.Focus;
import com.hiveview.entity.recommend.VideosetRecom;

public interface VideosetRecomDao extends BaseDao<VideosetRecom>{
	
	public List<Focus> getList(Map<String,Object> map);
	
	public Integer getCount(VideosetRecom videosetRecom);
	
	/**
	 * 根据contentid contentType 判断数据是否已经存在
	 * @param hdFocus
	 * @return
	 */
	VideosetRecom getById(VideosetRecom videosetRecom);
}
