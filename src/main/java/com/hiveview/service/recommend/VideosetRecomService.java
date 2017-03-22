package com.hiveview.service.recommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.recommend.VideosetRecomDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.Focus;
import com.hiveview.entity.recommend.VideosetRecom;

@Service
public class VideosetRecomService {
	
	@Autowired
	private VideosetRecomDao videosetRecomDao;
	
	/** 添加 **/
	public int save(VideosetRecom videosetRecom){
		VideosetRecom f = videosetRecomDao.getById(videosetRecom);
		if(f != null){
			return -1;
		}else{
			return videosetRecomDao.save(videosetRecom);
		}
	}
	
	/** 修改 **/
	public int update(VideosetRecom videosetRecom){
		return videosetRecomDao.update(videosetRecom);
	}
	
	/** 删除 **/
	public int delete(VideosetRecom videosetRecom){
		return videosetRecomDao.delete(videosetRecom);
	}
	
	/** 获取列表 **/
	public ScriptPage getList(VideosetRecom videosetRecom,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("contentName",videosetRecom.getContentName());
		map.put("contentType",videosetRecom.getContentType());
		map.put("pageIndex", ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		List<Focus> rows = videosetRecomDao.getList(map);
		scriptPage.setRows(rows);
		int total = videosetRecomDao.getCount(videosetRecom);
		scriptPage.setTotal(total);
		return scriptPage;
	}
}
