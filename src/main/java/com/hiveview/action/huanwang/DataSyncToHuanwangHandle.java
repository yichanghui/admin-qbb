package com.hiveview.action.huanwang;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.po.huanwang.ContentMedia;
import com.hiveview.entity.po.huanwang.ContentVideo;
import com.hiveview.service.huanwang.InterfaceListService;
import com.hiveview.util.huan.HuanUtil;

@Controller
@RequestMapping("/syncToHuanwangHandle")
public class DataSyncToHuanwangHandle {
	
	@Autowired
	private InterfaceListService interfaceListService;

	public void dataHandler(){
//		1.获得所有频道
//		2.通过频道获得专辑的总记录数
//		3.分布查询专辑
//		4.获得专辑信息
//		5.发送专辑信息
//		6.通过专辑Id查询剧集
//		7.发送剧集信息
	}
	
	@RequestMapping(value="/huanWang", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public void huanWang(){
		interfaceListService.syncMedia();
	}
	
	public void threadSyncMediaHuanData(String action,Map<String,Object> map){
		ContentMedia media = (ContentMedia)map.get("obj");
		operateMedia(action,media.getMediaId(),media);
	}
	public void threadSyncVideoHuanData(String action,Map<String,Object> map){
		ContentVideo video = (ContentVideo)map.get("obj");
		operateVideo(action,video.getMediaId(),video);	
	}
	
	private void operateMedia(String action,int mediaId,ContentMedia media){
		HuanUtil.syncDataToHuan(HuanUtil.getMap(action,mediaId, media));
	}
	
	private void operateVideo(String action,int mediaId,ContentVideo video){
		HuanUtil.syncDataToHuan(HuanUtil.getMap(action,mediaId, video));
	}
	
}
