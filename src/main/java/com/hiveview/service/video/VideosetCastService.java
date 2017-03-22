package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.VideosetCastDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.VideosetCast;

@Service
public class VideosetCastService {
	
	@Autowired
	private VideosetCastDao videosetCastDao;
	
	/** 添加 **/
	public int save(VideosetCast videosetcast){
		return videosetCastDao.save(videosetcast);
	}
	
	/** 修改 **/
	public int update(VideosetCast videosetcast){
		return videosetCastDao.update(videosetcast);
	}
	
	/** 删除 **/
	public int delete(VideosetCast videosetcast){
		return videosetCastDao.delete(videosetcast);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(VideosetCast videosetcast,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("videosetId",videosetcast.getVideosetId());
		map.put("castId",videosetcast.getCastId());
		map.put("castType",videosetcast.getCastType());
		map.put("castName",videosetcast.getCastName());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<VideosetCast> rows = videosetCastDao.getList(map);
		scriptPage.setRows(rows);
		int total = videosetCastDao.getCount(videosetcast);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
