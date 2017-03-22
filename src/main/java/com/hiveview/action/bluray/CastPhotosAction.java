package com.hiveview.action.bluray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bluray.CastPhotos;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.bluray.CastPhotosService;
@Controller
@RequestMapping("/castphotos")
public class CastPhotosAction{

	@Autowired
	private CastPhotosService castPhotosService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show(CastPhotos castphotos) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("castId", castphotos.getCastId());
		mv.addObject("castType", castphotos.getCastType());
		mv.setViewName("bluray/castphotos_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(CastPhotos castphotos,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = castPhotosService.getList(castphotos,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(CastPhotos castphotos){
		Data data = new Data();
		int result = castPhotosService.save(castphotos);
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
	public Data update(CastPhotos castphotos){
		Data data = new Data();
		int result = castPhotosService.update(castphotos);
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
	public Data delete(CastPhotos castphotos){
		Data data = new Data();
		int result = castPhotosService.delete(castphotos);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

