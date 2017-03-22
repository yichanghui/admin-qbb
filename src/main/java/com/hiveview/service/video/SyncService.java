package com.hiveview.service.video;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.SyncVideoMapper;
import com.hiveview.dao.video.SyncVideoSetMapper;
import com.hiveview.dao.video.SyncVideoUrlMapper;
import com.hiveview.entity.video.SyncVideo;
import com.hiveview.entity.video.SyncVideoSet;
import com.hiveview.entity.video.SyncVideoUrl;

@Service
public class SyncService{
	
	
	@Autowired
	private SyncVideoSetMapper syncVideoSetMapper;
	@Autowired
	private SyncVideoMapper syncVideoMapper;
//	@Autowired
//	private SyncVideoPlayUrlMapper syncVideoPlayUrlMapper;
	@Autowired
	private SyncVideoUrlMapper syncVideoUrlMapper;
	

	public List<SyncVideoSet> getSyncVideoSetByPage(Map<String, Object> map){
		try {
			List<SyncVideoSet> list=syncVideoSetMapper.getAllByPage("SyncVideoSetMapper.getSyncVideoSetByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public List<SyncVideo> getSyncVideoByPage(Map<String, Object> map){
		try {
			List<SyncVideo> list=syncVideoMapper.getAllByPage("SyncVideoMapper.getSyncVideoByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	public List<SyncVideo> getSyncVideoForUpdateByPage(Map<String, Object> map){
		try {
			List<SyncVideo> list=syncVideoMapper.getAllByPage("SyncVideoMapper.getSyncVideoForUpdateByPage", map);
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
//	public SyncVideoPlayUrl getVideoUrlById(SyncVideoPlayUrl playUrl){
//		try {
//			SyncVideoPlayUrl syncVideoPlayUrl=syncVideoPlayUrlMapper.getInfoById("SyncVideoPlayUrlMapper.getSyncVideoPlayUrlById", playUrl);
//			return syncVideoPlayUrl;
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			return null;
//		}
//	}
	
	/**
	 * 根据参数查询videoset总记录数
	 * @param map
	 * @return
	 */
	public int getVideoSetCountByPage(Map<String, Object> map){
		try {
			return syncVideoSetMapper.getCountByPage("SyncVideoSetMapper.getCountByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 根据参数查询videoinfo总记录数
	 * @param map
	 * @return
	 */
	public int getVideoInfoCountByPage(Map<String, Object> map){
		try {
			return syncVideoMapper.getCountByPage("SyncVideoMapper.getCountByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**检查更新**/
	public int getSyncVideoCountForUpdate(Map<String, Object> map){
		try {
			return syncVideoMapper.getCountByPage("SyncVideoMapper.getSyncVideoCountForUpdate", map);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 分页查询播放地址信息
	 * @param map
	 * @return
	 */
	public List<SyncVideoUrl>  getSyncVideoUrl(Map<String,Object> map){
		try {
			List<SyncVideoUrl> list=syncVideoUrlMapper.getAllByPage("SyncVideoUrlMapper.getVideoUrlByPage", map);		
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 查询播放地址的总条数
	 * @param map
	 * @return
	 */
	public int getSyncVideoUrlCountByPage(Map<String,Object> map){
		try {
			return syncVideoUrlMapper.getCountByPage("SyncVideoUrlMapper.getVideoUrlCountByPage", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
	}
	
}
