package com.hiveview.action.video;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.action.comm.JedisUtil;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.Video;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.service.video.VideoService;
import com.hiveview.util.DateUtil;

@Controller
@RequestMapping("/video")
public class VideoAction{
	
	@Autowired
	private VideoService videoService;
	
	/**
	 * 分页查询video信息
	 * @param pageAjax
	 * @param video
	 * @return
	 */
	@RequestMapping(value="/getVideoByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoByPage(AjaxPage pageAjax,Video video){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("video", video);
		List<Video> videoList = videoService.getVideoByPage(map);
		scriptPage.setRows(videoList);
		scriptPage.setTotal(videoService.getVideoCountByPage(map));
		return scriptPage;
	}
	
	
	/**
	 * 猜你喜欢的剧集列表(针对栏目，新闻其实类型直接查询的专辑表)
	 * @return
	 */
	@RequestMapping(value="/getVideoForRelateByPage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoForRelateByPage(VideoSet videoset,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		Video video = new Video();
		video.setVideoType(videoset.getVideosetType());
		video.setVideoName(videoset.getVideosetName());
		video.setContentType(videoset.getContentType());
		map.put("video", video);
		List<VideoSet> list=videoService.getVideoForRelateByPage(map);
		scriptPage.setRows(list);
		scriptPage.setTotal(videoService.getVideoCountByPage(map));
		return scriptPage;
	}
	
	/**
	 * 更新video信息
	 * @param video
	 * @return
	 */
	@RequestMapping(value="/updateVideo", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVideo(Video video){
		try {
			int num=videoService.updateVideo(video);
			if(num==1){
				return new Data();
			}else{
				return new Data(0,"没有找到要修改的信息！");
			}
		} catch (Exception e) {
			return new Data(0,e.getMessage());
		}
	}
	
	/**
	 * 更新video信息
	 * @param video
	 * @return
	 */
	@RequestMapping(value="/batchUpdateVideo", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data batchUpdateVideo(Long videosetId,String videoIds){
		try {
			int num=videoService.batchUpdateVideo(videosetId,videoIds);
			if(num==1){
				return new Data();
			}else{
				return new Data(0,"没有找到要修改的信息！");
			}
		} catch (Exception e) {
			return new Data(0,e.getMessage());
		}
	}
	/**
	 * 根据ID获取video信息
	 * @param videoId
	 * @return
	 */
	@RequestMapping(value="/getVideoById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Video getVideoById(Long videoId){
		Video video=videoService.getVideoById(videoId);
		return video;
	}
	
	
	/**
	 * 根据videoSetID获取video信息
	 * @param videoId
	 * @return
	 */
	@RequestMapping(value="/getVideoByVideoSetId", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoByVideoSetId(Long videoSetId){
		ScriptPage scriptPage=new ScriptPage();
		List<Video> videoList=videoService.getVideoByVideoSetId(videoSetId);
		if(videoList!=null){
			scriptPage.setRows(videoList);
		}
		return scriptPage;
	}
	
	
	
	
	
	/**
	 * 根据ID删除video信息
	 * @param videoId
	 * @return
	 */
	@RequestMapping("/deleteVideo")
	@ResponseBody
	public Data deleteVideo(Long videoId){
		int num=videoService.deleteVideo(videoId);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
	/**
	 * 添加video信息
	 * @param video
	 * @return
	 */
	@RequestMapping(value="/saveVideo", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveVideo(Video video){
		video.setContentType(1);
		video.setCreateTime(DateUtil.getTimeStamp(new Date()));
		int num=videoService.saveVideo(video);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"保存失败！");
		}
	}
	
	@RequestMapping(value="/synchronousData", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data synchronousData(String videoIds){
		if(JedisUtil.save("videoIds", videoIds)<=0){
			return new Data(0,"no synchronous data");
		}else{
			return new Data();
		}
	}
	
	@RequestMapping(value="/changeStateForVideo", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data changeStateForVideo(String videoIds,int state,String videos,Boolean flagHuan){
		try {
			if(videoService.changeStateForVideo(videoIds, state,videos,flagHuan)>=1)
				return new Data();
			else
				return new Data(0,"no update data！！！");
		} catch (Exception e) {
			e.printStackTrace();
			return new Data();
		}
	}
}
