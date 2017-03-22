package com.hiveview.action.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.Subject;
import com.hiveview.service.recommend.SubjectService;
@Controller
@RequestMapping("/subject")
public class SubjectAction{

	@Autowired
	private SubjectService subjectService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recommend/subject_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(Subject subject,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = subjectService.getList(subject,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(Subject subject){
		Data data = new Data();
		int result = subjectService.save(subject);
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
	public Data update(Subject subject){
		Data data = new Data();
		int result = subjectService.update(subject);
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
	public Data delete(Subject subject){
		Data data = new Data();
		int result = subjectService.delete(subject);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

