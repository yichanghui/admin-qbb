package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.VideoSetDao;
import com.hiveview.dao.video.VideoUrlDao;
import com.hiveview.entity.video.VideoUrl;

@Service
public class VideoUrlService{
	
	@Autowired
	private VideoUrlDao videoUrlMapper;
	@Autowired
	private VideoSetDao videoSetDao;
	
	public int saveVideoUrl(VideoUrl videoUrl,Integer videosetId,String dataRate){
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("videoUrl", videoUrl);
			map.put("currentPage", 0);
			map.put("pageSize",1);
			List<VideoUrl> list = videoUrlMapper.getAllByPage("VideoUrlMapper.getVideoUrlByPage", map);
			if(null!=list&&0!=list.size()){
				return -1;
			}
			threadUpdateVideosetFor_dataRate(videosetId,dataRate);
			return videoUrlMapper.saveInfo("VideoUrlMapper.addVideoUrl", videoUrl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public List<VideoUrl> getVideoUrlByPage(Map<String,Object> map){
		try {
			return videoUrlMapper.getAllByPage("VideoUrlMapper.getVideoUrlByPage", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public int getVideoUrlCountByPage(Map<String,Object> map){
		try {
			return videoUrlMapper.getCountByPage("VideoUrlMapper.getVideoUrlCountByPage", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int updateVideoUrl(VideoUrl videoUrl){
		try {
			return videoUrlMapper.updateById("VideoUrlMapper.updateVideoUrl",videoUrl);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
	public int delVideoUrl(Map<String,Object> map,Integer videosetId,String dataRate){
		try {
			threadUpdateVideosetFor_dataRate(videosetId,dataRate);
			return videoUrlMapper.delByIf("VideoUrlMapper.delVideoUrl", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	//添加，修改码流时同时更新专辑表 date_rate
	private void threadUpdateVideosetFor_dataRate(Integer videosetId,String dataRate){
		//videoSetDao.updateById(mapperName, obj);
		//获得这个剧集的所有码流
		// code...——————》剧集ID查询码流列表，
		//通过专辑ID修改dataRate字段
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("videosetId",videosetId);
		map.put("dataRate", dataRate);
		videoSetDao.updateByIf("VideoSetMapper.updateVideosetDatarate",map);
	}
	
}
