package com.hiveview.dao.video;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseMapper;
import com.hiveview.entity.video.Video;
import com.hiveview.entity.video.VideoSet;

@Repository
public class VideoDao extends BaseMapper<Video>{
	public List<VideoSet> getVideoForRelateByPage(Map<String, Object> map){
		List<VideoSet> list = this.getSqlSession().selectList("VideoMapper.getVideoForRelateList", map); 
		for(VideoSet vs:list){
			System.out.println(vs.getVideosetType());
		}
		return list;
	}
	
	public int batchUpdateVideo(Video video){
		return this.getSqlSession().update("VideoMapper.batchUpdateVideo",video);
	}

}
