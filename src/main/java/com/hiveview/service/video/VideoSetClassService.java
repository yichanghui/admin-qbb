package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.VideoSetClassMapper;
import com.hiveview.dao.video.VideoSetDao;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.entity.video.VideoSetClass;
@Service
public class VideoSetClassService{
	
	
	@Autowired
	private VideoSetClassMapper videoSetClassMapper;
	@Autowired
	private VideoSetDao videoSetDao;
	
	public List<VideoSetClass>  getClassByPage(Map<String,Object>  map){
		try {
			List<VideoSetClass> list=videoSetClassMapper.getAllByPage("VideoSetClassMapper.getClassByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
	public int getClassCountByPage(Map<String,Object>  map){
		try {
			return  videoSetClassMapper.getCountByPage("VideoSetClassMapper.getClassCountByPage", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int saveVideoSetClass(VideoSetClass videoSetClass){
		try {
			//先删除重复的
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("videoSetClass", videoSetClass);
			videoSetClassMapper.delByIf("VideoSetClassMapper.delVideosetClass", map);
			videoSetClassMapper.saveInfo("VideoSetClassMapper.addVideoSetClass", videoSetClass);//保存标签
			return getVideosetToUpdate(videoSetClass); //修改专辑标签
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	
	public int deleteClass(VideoSetClass videoSetClass){
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("videoSetClass", videoSetClass);
			videoSetClassMapper.delByIf("VideoSetClassMapper.delVideosetClass", map);
			return getVideosetToUpdate(videoSetClass);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}

	
	public Integer getVideosetToUpdate(VideoSetClass videoSetClass){
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("videoSetClass", videoSetClass);
		map.put("currentPage",0);
		map.put("pageSize",20);
		List<VideoSetClass> list = videoSetClassMapper.getAllByPage("VideoSetClassMapper.getClassByPage", map);
		StringBuffer tag = new StringBuffer();
		for(VideoSetClass v:list){
			tag.append(v.getThirdclassName()).append(",");
		}
		VideoSet videoset = new VideoSet();
		videoset.setVideosetId(videoSetClass.getVideosetId());
		videoset.setTagSearch(tag.toString());
		return videoSetDao.updateById("VideoSetMapper.updateVideoSet", videoset);
	}
}
