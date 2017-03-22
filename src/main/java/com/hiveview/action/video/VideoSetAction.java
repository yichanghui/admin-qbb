package com.hiveview.action.video;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.action.comm.JedisUtil;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.Video;
import com.hiveview.entity.video.VideoSet;
import com.hiveview.service.video.FilmReviewService;
import com.hiveview.service.video.VideoService;
import com.hiveview.service.video.VideoSetSerivce;
import com.hiveview.util.PinyinUtil;

@Controller
@RequestMapping("/videoSet")
public class VideoSetAction{
	
	@Autowired
	private VideoSetSerivce videoSetService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private FilmReviewService filmReviewService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("video/videoset_list");
		return mv;
	}
	
	@RequestMapping(value="/getVideoSetByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoByPage(AjaxPage ajaxPage,VideoSet videoSet){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		map.put("videoSet", videoSet);
		List<VideoSet> videoSetList = videoSetService.getVideoSetByPage(map);
		scriptPage.setRows(videoSetList);
		scriptPage.setTotal(videoSetService.getVideoSetCountByPage(map));
		return scriptPage;
	}
	
	
	@RequestMapping(value="/updateVideoSet", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVideoSet(VideoSet videoSet){
		Data data = new Data();
		videoSet.setPyName(PinyinUtil.getFirstHanyuPinyin(videoSet.getVideosetName()));
		int num=videoSetService.updateVideoSet(videoSet);
		if(num==1){
			return data;
		}else{
			data.setCode(0);
			data.setMsg("修改失败！");
			return data;
		}
	}
	
	@RequestMapping(value="/updateIsEffective", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateIsEffective(VideoSet videoSet){
		Data data = new Data();
		int num=videoSetService.updateVideoSet(videoSet);
		Map<String,Object> videoMap=new HashMap<String, Object>();
		videoMap.put("videosetId",videoSet.getVideosetId());
		videoMap.put("isEffective", videoSet.getIsEffective());
		videoService.updateIsEffByVideosetId(videoMap);
		List<Video> videoList=this.videoService.getVideoByVideoSetId(videoSet.getVideosetId());
		for(Video video:videoList){
			Map<String,Object> playUrlMap=new HashMap<String, Object>();
			playUrlMap.put("videoId",video.getVideoId());
			playUrlMap.put("isEffective",videoSet.getIsEffective());
			videoService.updatePlayUrlIsEff(playUrlMap);
			
		}
		if(num==1){
			return data;
		}else{
			data.setCode(0);
			data.setMsg("操作失败！");
			return data;
		}
	}
	
	
	
	
	
	/**
	 * 根据ID获取videoSet信息
	 * @param videoSetId
	 * @return
	 */
	@RequestMapping(value="/getVideoSetById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public VideoSet getVideoSetById(Long videoSetId){
		VideoSet videoSet=videoSetService.getVideoSetById(videoSetId);
		return videoSet;
	}
	
	
	@RequestMapping("/deleteVideoSet")
	@ResponseBody
	public Data deleteVideoSet(Long videoSetId,Integer isEffective,String classFirstName){
		Data data = new Data();
		isEffective = isEffective==1?0:1;
		int num=videoSetService.deleteVideoSet(videoSetId,isEffective,classFirstName);
		if(num==1){
			return data;
		}else{
			data.setCode(0);
			data.setMsg("删除失败！");
			return data;
		}
	}
	@RequestMapping(value="/addVideoSet", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveVideoSet(VideoSet videoSet){
		Data data = new Data();
		videoSet.setPyName(PinyinUtil.getFirstHanyuPinyin(videoSet.getVideosetName()));
		if(videoSet.getSeq()<=50){
			topVideoset(null,50,null,videoSet.getSeq());
		}
		int num=videoSetService.saveVideoSet(videoSet);
		if(num==1){
			return data;
		}else{
			data.setCode(0);
			return data;
		}
	}
	
	
	/**
	 * 分页获取专辑信息
	 * 用于猜你喜欢
	 * @param pageAjax
	 * @param videoSet
	 * @return
	 */
	@RequestMapping(value="/getVideoSetRelatedByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVideoSetByPage(AjaxPage ajaxPage,VideoSet videoSet){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",ajaxPage.getSkipNo());
		map.put("pageSize", ajaxPage.getPageSize());
		map.put("videoSet", videoSet);
		List<VideoSet> videoSetList = videoSetService.getVideoSetRelateByPage(map);
		scriptPage.setRows(videoSetList);
		scriptPage.setTotal(videoSetService.getVideoSetRelateCountByPage(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/synchronousData", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data synchronousData(String videosetIds){
		try {
			int flag = JedisUtil.save("videosetIds", videosetIds);
			if(flag<=0){
				return new Data();
			}else{
				return new Data(0,"加入队列失败");
			}
		} catch (Exception e) {
			return new Data(0,e.getMessage());
		}
	}
	
	/**
	 * 上下移，置顶
	 * @param videosetIds
	 * @return
	 */
	@RequestMapping(value="/updateVideoSetSequence", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVideoSetSequence(Long videosetId,Integer seq,Long videosetId_,Integer seq_,Integer flag){
		/***************** 上移--下移 ******************/
		try {
			/***************** 置顶 ******************/
			if(flag==3){
				topVideoset(videosetId,seq,videosetId_,seq_);
				return new Data();
			}
			//交换位置
			int tempSeq=seq;
			seq=seq_;
			seq_=tempSeq;
			//持久化数据
			VideoSet v1=new VideoSet();
			v1.setSeq(seq);
			v1.setVideosetId(videosetId);
			videoSetService.updateVideoSetSeq(v1);
			
			VideoSet v2=new VideoSet();
			v2.setSeq(seq_);
			v2.setVideosetId(videosetId_);
			videoSetService.updateVideoSetSeq(v2);
			return new Data();
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"");
		}
	}
	private Integer topVideoset(Long videosetId,Integer seq,Long videosetId_,Integer seq_){
		Integer flag=0;
		if(seq>seq_){//专辑上移
			if(seq<=50)//50个以内
				flag=updateVideoSetSeq(seq_,seq,1);
			else//50个以外
				flag=updateVideoSetSeq(seq_,50,1);
		}else{//专辑下移
			flag=updateVideoSetSeq(seq,seq_,2);
		}
		if(null!=videosetId){
			VideoSet v1=new VideoSet();
			v1.setSeq(seq_);
			v1.setVideosetId(videosetId);
			flag=videoSetService.updateVideoSetSeq(v1);
		}
		return flag;
	}
	private Integer updateVideoSetSeq(Integer seq1,Integer seq2,Integer flag){
		return videoSetService.updateVideoSet(seq1,seq2,flag);
	}
	
	
	@RequestMapping(value="/getReviewList",method = RequestMethod.POST)
	@ResponseBody
	public ScriptPage getReviewList(String videoName,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = filmReviewService.getFileReview(videoName, ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
}
