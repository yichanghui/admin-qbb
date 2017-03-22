package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.hiveview.dao.video.VideoDao;
import com.hiveview.entity.video.Video;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.util.huan.HuanUtil;

@Service
public class VideoService{
	
	@Autowired
	private VideoDao videoMapper;

	
	public List<Video> getVideoByPage(Map<String, Object> map){
		try {
			List<Video> list=videoMapper.getAllByPage("VideoMapper.getVideoByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public List<VideoSet> getVideoForRelateByPage(Map<String, Object> map){
		try {
			List<VideoSet> list = videoMapper.getVideoForRelateByPage(map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public Video getVideoById(Long videoId){
		try {
			Video video=videoMapper.getInfoById("VideoMapper.getVideoById", videoId);
			return video;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	public List<Video> getVideoByVideoSetId(Long videosetId){
		try {
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("videosetId", videosetId);
			List<Video> videos=videoMapper.getInfoById("VideoMapper.getVideoByVideoSetId", map);
			return videos;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	
	public int getVideoCountByPage(Map<String, Object> map){
		try {
			int count=videoMapper.getCountByPage("VideoMapper.getCountByPage", map);
			return count;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updatePlayUrlIsEff(Map<String,Object> map){
		try {
			return videoMapper.updateByIf("VideoUrlMapper.updatePlayUrlIsEff", map);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int updateVideo(Video video){
		
		try {
			return videoMapper.updateById("VideoMapper.updateVideo", video);	
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int batchUpdateVideo(Long videosetId,String videoIds){
		try {
			String [] videoId = videoIds.split(",");
			int i=0;
			for(i=0;i<videoId.length;i++){
				Video video = new Video();
				video.setVideosetId(videosetId);
				video.setVideoId(Long.parseLong(videoId[i]));
				videoMapper.batchUpdateVideo(video);
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateIsEffByVideosetId(Map<String,Object> map){
		try{
			return videoMapper.updateByIf("VideoMapper.updateIsEffByVideosetId",map);
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int deleteVideo(Long videoId){
		try {
			return videoMapper.delById("VideoMapper.deleteVideo", videoId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public int saveVideo(Video video){
		try {
			if(videoMapper.saveInfo("VideoMapper.addVideo", video)>0){
				HuanUtil.threadSyncVideoForHuan("addVideo",video);
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	public int changeStateForVideo(String videoIds,int state,String videos,Boolean flagHuan){
		try {
			String []videoIdArray = videoIds.split(",");
			for(String videoId:videoIdArray){
				Video video = new Video();
				video.setVideoId(Long.parseLong(videoId));
				video.setIsEffective(state);
				videoMapper.updateById("VideoMapper.updateVideo", video);
			}
			if(state==0){
				this.threadSyncVideoForHuan("deleteVideo",videos);
			}else if(state==1&&flagHuan){
				this.threadSyncVideoForHuan("addVideo",videos);
			}
			return  1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	private void threadSyncVideoForHuan(String action,String videos){
		Video[] list = JSON.parseObject(videos,new TypeReference<Video[]>(){});
		int length = list.length;
		for (int i = 0; i < length; i++) {
			HuanUtil.threadSyncVideoForHuan(action,(Video)list[i]);
		}
	}
}
