package com.hiveview.action.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.SyncVideo;
import com.hiveview.entity.video.SyncVideoSet;
import com.hiveview.entity.video.SyncVideoUrl;
import com.hiveview.service.video.SyncService;

@Controller
@RequestMapping("/sync")
public class SyncAction{
	
	@Autowired
	private SyncService syncService;
	
	/**
	 *  分页查询SyncVideoSet信息
	 * @param pageAjax
	 * @param syncVideoset
	 * @return
	 */
	@RequestMapping(value = "/getSyncVideoSetByPage", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ScriptPage getSyncVideoSetByPage(AjaxPage pageAjax,SyncVideoSet syncVideoset) {
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("syncVideoset", syncVideoset);
		List<SyncVideoSet> syncVideoSetList = syncService.getSyncVideoSetByPage(map);
		scriptPage.setRows(syncVideoSetList);
		scriptPage.setTotal(syncService.getVideoSetCountByPage(map));
		return scriptPage;
	}
	
	/**
	 * 分页查询SyncVideoInfo信息
	 * @param pageAjax
	 * @param syncVideo
	 * @return
	 */
	@RequestMapping(value="/getSyncVideoInfoByPage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getSyncVideoInfoByPage(AjaxPage  pageAjax,SyncVideo syncVideo){
		ScriptPage scriptPage=new ScriptPage();
		if(syncVideo!=null&&syncVideo.getVideosetId()!=null){
			if(syncVideo.getVideoType()==2){
				syncVideo.setColumnId(Long.parseLong(syncVideo.getVideosetId()));
				syncVideo.setVideosetId(null);
			}else if(syncVideo.getVideoType()==4){
				syncVideo.setColumnId(Long.parseLong(syncVideo.getVideosetId()));
				syncVideo.setContentType(1);
				syncVideo.setVideosetId(null);
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("syncVideo", syncVideo);
		List<SyncVideo> syncVideoInfoList=syncService.getSyncVideoByPage(map);
		scriptPage.setRows(syncVideoInfoList);
		scriptPage.setTotal(syncService.getVideoInfoCountByPage(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/getSyncVideoForUpdateByPage",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getSyncVideoForUpdateByPage(AjaxPage pageAjax,SyncVideo syncVideo){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("syncVideo", syncVideo);
		List<SyncVideo> syncVideoInfoList=syncService.getSyncVideoForUpdateByPage(map);
		scriptPage.setRows(syncVideoInfoList);
		scriptPage.setTotal(syncService.getSyncVideoCountForUpdate(map));
		return scriptPage;
	}
	
	/**
	 *  根据videoSetId查询SyncVideo信息
	 * @param pageAjax
	 * @param syncVideoset
	 * @return
	 */
	@RequestMapping(value = "/getSyncVideoByPage", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ScriptPage getSyncVideoByPage(AjaxPage pageAjax,SyncVideo syncVideo) {
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("syncVideo", syncVideo);
		List<SyncVideo> syncVideoList = syncService.getSyncVideoByPage(map);
		scriptPage.setRows(syncVideoList);
		//pageAjax.setAllCount(super.getSyncService().ge);
		return scriptPage;
	}
	
	
	/**
	 * 根据Id查询SyncVideo信息
	 * @param syncVideoset
	 * @return
	 */
	@RequestMapping(value = "/getSyncVideoByIf", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SyncVideo getSyncVideoByIf(SyncVideo syncVideo) {
		Map<String, Object> map = new HashMap<String, Object>();
		//AjaxPage pageAjax=new PageAjax();
		map.put("currentPage",0);
		map.put("pageSize",10);
		map.put("syncVideo", syncVideo);
		List<SyncVideo> syncVideoList = syncService.getSyncVideoByPage(map);
		if(syncVideoList!=null&&syncVideoList.size()!=0){
			return syncVideoList.get(0);
		}
		
		return null;
	}
	
	/**
	 * 根据Id查询SyncVideoSet信息
	 * @param syncVideoset
	 * @return
	 */
	@RequestMapping(value = "/getSyncVideoSetByIf", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public SyncVideoSet getSyncVideoSetByIf(SyncVideoSet syncVideoset) {
		Map<String, Object> map = new HashMap<String, Object>();
		//PageAjax pageAjax=new PageAjax();
		map.put("currentPage",0);
		map.put("pageSize", 10);
		map.put("syncVideoset", syncVideoset);
		List<SyncVideoSet> syncVideoSetList = syncService.getSyncVideoSetByPage(map);
		if(syncVideoSetList!=null&&syncVideoSetList.size()!=0){
			return syncVideoSetList.get(0);
		}
		return null;
	}
	
	/**
	 * 分页获取播放地址总条数
	 * @param pageAjax
	 * @param syncVideoUrl
	 * @return
	 */
	@RequestMapping(value="/getSyncVideoUrl",produces={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getSyncVideoUrlByPage(AjaxPage pageAjax,SyncVideoUrl syncVideoUrl){
		ScriptPage scriptPage=new ScriptPage();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("syncVideoUrl", syncVideoUrl);
		List<SyncVideoUrl>  list=syncService.getSyncVideoUrl(map);
		scriptPage.setRows(list);
		scriptPage.setTotal(syncService.getSyncVideoUrlCountByPage(map));
		return scriptPage;
	}

}
