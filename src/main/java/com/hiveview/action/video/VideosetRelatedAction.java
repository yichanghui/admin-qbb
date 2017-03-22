
package com.hiveview.action.video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.video.VideosetRelated;
import com.hiveview.service.video.VideosetRelatedService;
@Controller
@RequestMapping("/videosetrelated")
public class VideosetRelatedAction{

	@Autowired
	private VideosetRelatedService videosetRelatedService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("videosetrelated/videosetrelated_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(VideosetRelated videosetrelated,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = videosetRelatedService.getList(videosetrelated,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(VideosetRelated videosetrelated){
		Data data = new Data();
		int result = videosetRelatedService.save(videosetrelated);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(VideosetRelated videosetrelated){
		Data data = new Data();
		int result = videosetRelatedService.update(videosetrelated);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 删除信息 **/
	@RequestMapping(value="/delete")
	@ResponseBody
	public Data delete(VideosetRelated videosetrelated){
		Data data = new Data();
		int result = videosetRelatedService.delete(videosetrelated);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

