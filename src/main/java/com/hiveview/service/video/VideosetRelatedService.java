package com.hiveview.service.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.video.VideosetRelatedDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.VideosetRelated;

@Service
public class VideosetRelatedService {
	
	@Autowired
	private VideosetRelatedDao videosetRelatedDao;
	
	/** 添加 **/
	public int save(VideosetRelated videosetrelated){
		return videosetRelatedDao.save(videosetrelated);
	}
	
	/** 修改 **/
	public int update(VideosetRelated videosetrelated){
		return videosetRelatedDao.update(videosetrelated);
	}
	
	/** 删除 **/
	public int delete(VideosetRelated videosetrelated){
		return videosetRelatedDao.delete(videosetrelated);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(VideosetRelated videosetrelated,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("videosetId",videosetrelated.getVideosetId());
		map.put("contentType",videosetrelated.getRelatedContentType());
		map.put("videosetName",videosetrelated.getVideosetName());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<VideosetRelated> rows = videosetRelatedDao.getList(map);
		scriptPage.setRows(rows);
		int total = videosetRelatedDao.getCount(videosetrelated);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
