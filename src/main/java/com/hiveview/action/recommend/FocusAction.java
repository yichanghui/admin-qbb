package com.hiveview.action.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.Focus;
import com.hiveview.service.recommend.FocusService;
@Controller
@RequestMapping("/focus")
public class FocusAction{

	@Autowired
	private FocusService focusService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recommend/focus_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(Focus focus,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = focusService.getList(focus,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(Focus focus){
		Data data = new Data();
		int result = focusService.save(focus);
		data.setCode(result);
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(Focus focus){
		Data data = new Data();
		int result = focusService.update(focus);
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
	public Data delete(Focus focus){
		Data data = new Data();
		int result = focusService.delete(focus);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping(value="/getAppListClassify")
	@ResponseBody
	public ScriptPage getAppListClassify(Integer categoryId,String appName,AjaxPage ajaxPage){
		return focusService.getAppListClassify(categoryId,appName,ajaxPage);
	}
}