package com.hiveview.action.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.VideosetRecom;
import com.hiveview.service.recommend.VideosetRecomService;
@Controller
@RequestMapping("/videosetRecom")
public class VideosetRecomAction{

	@Autowired
	private VideosetRecomService videosetRecomService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recommend/videosetRecom_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(VideosetRecom videosetRecom,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = videosetRecomService.getList(videosetRecom,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(VideosetRecom videosetRecom){
		Data data = new Data();
		int result = videosetRecomService.save(videosetRecom);
		data.setCode(result);
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(VideosetRecom videosetRecom){
		Data data = new Data();
		int result = videosetRecomService.update(videosetRecom);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(result);
		}
		return data;
	}
	/** 删除信息 **/
	@RequestMapping(value="/delete")
	@ResponseBody
	public Data delete(VideosetRecom videosetRecom){
		Data data = new Data();
		int result = videosetRecomService.delete(videosetRecom);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}