package com.hiveview.action.app.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.app.AppSubjectContent;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.app.AppSubjectContentService;
@Controller
@RequestMapping("/appsubjectcontent")
public class AppSubjectContentAction{

	@Autowired
	private AppSubjectContentService appSubjectContentService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/app/appsubjectcontent_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(AppSubjectContent appsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appSubjectContentService.getList(appsubjectcontent,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/**
	 * 查询专题内容，显示应用信息
	 * @param appsubjectcontent
	 * @param ajaxPage
	 * @return
	 */
	@RequestMapping(value="/getInfoList")
	@ResponseBody
	public ScriptPage getInfoList(AppSubjectContent appsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appSubjectContentService.getInfoList(appsubjectcontent,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(AppSubjectContent appsubjectcontent){
		Data data = new Data(0,"");
		try {
			int result = appSubjectContentService.save(appsubjectcontent);
			if(result>0){
				data.setCode(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(AppSubjectContent appsubjectcontent){
		Data data = new Data(0,"");
		try {
			int result = appSubjectContentService.update(appsubjectcontent);
			if(result>0){
				data.setCode(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}
	/** 删除信息 **/
	@RequestMapping(value="/delete")
	@ResponseBody
	public Data delete(AppSubjectContent appsubjectcontent){
		Data data = new Data();
		int result = appSubjectContentService.delete(appsubjectcontent);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

