package com.hiveview.action.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.VideoUrl;
import com.hiveview.service.video.VideoUrlService;

@Controller
@RequestMapping("/videoUrl")
public class VideoUrlAction{
	
	@Autowired
	private VideoUrlService videoUrlService;
	
	/**
	 * 分页获取播放地址信息
	 * @param pageAjax
	 * @param videoUrl
	 * @return
	 */
	@RequestMapping(value="/getVideoUrlByPage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoUrlByPage(AjaxPage pageAjax,VideoUrl videoUrl){
		ScriptPage scriptPage=new ScriptPage();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("currentPage", pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("videoUrl", videoUrl);
		List<VideoUrl> list=videoUrlService.getVideoUrlByPage(map);
		scriptPage.setRows(list);
		scriptPage.setTotal(videoUrlService.getVideoUrlCountByPage(map));
		return scriptPage;
	}
	
	/**
	 * 保存播放地址信息
	 * @param videoUrl
	 * @return
	 */
	@RequestMapping(value="/saveVideoUrl",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveVideoUrl(VideoUrl videoUrl,Integer videosetId,String dataRate){
		int num=videoUrlService.saveVideoUrl(videoUrl,videosetId,dataRate);
		if(num==1){
			return new Data();
		}else if(num==-1){
			return new Data(2,"exist");
		}else{
			return new Data(0,"未知错误！");
		}
	}
	
	/**
	 * 修改播放地址
	 * @param videoUrl
	 * @return
	 */
	@RequestMapping(value="/updateVideoUrl",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVideoUrl(VideoUrl videoUrl,Integer videosetId,String dataRate){
		int num=videoUrlService.updateVideoUrl(videoUrl);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"未知错误！");
		}
	}
	
	/**
	 * 删除播放地址
	 * @param videoUrl
	 * @return
	 */
	@RequestMapping(value="/delVideoUrl",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data delVideoUrl(VideoUrl videoUrl,Integer videosetId,String dataRate){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("videoUrl", videoUrl);
		int num=videoUrlService.delVideoUrl(map,videosetId,dataRate);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"未知错误！");
		}
	}
}
