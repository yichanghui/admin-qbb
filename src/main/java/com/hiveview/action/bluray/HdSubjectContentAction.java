package com.hiveview.action.bluray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bluray.HdSubjectContent;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.bluray.HdSubjectContentService;
@Controller
@RequestMapping("/hdsubjectcontent")
public class HdSubjectContentAction{

	@Autowired
	private HdSubjectContentService hdSubjectContentService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bluray/hdsubjectcontent_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(HdSubjectContent hdsubjectcontent,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			System.out.println(hdsubjectcontent.getSubjectId());
			scriptPage = hdSubjectContentService.getList(hdsubjectcontent,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(HdSubjectContent hdsubjectcontent){
		Data data = new Data();
		int result = hdSubjectContentService.save(hdsubjectcontent);
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
	public Data update(HdSubjectContent hdsubjectcontent){
		Data data = new Data();
		int result = hdSubjectContentService.update(hdsubjectcontent);
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
	public Data delete(HdSubjectContent hdsubjectcontent){
		Data data = new Data();
		int result = hdSubjectContentService.delete(hdsubjectcontent);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

