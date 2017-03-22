
package com.hiveview.action.app.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.app.SearchApp;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.app.SearchAppService;
@Controller
@RequestMapping("/searchapp")
public class SearchAppAction{

	@Autowired
	private SearchAppService searchAppService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/app/searchapp_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(SearchApp searchapp,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = searchAppService.getList(searchapp,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(SearchApp searchapp){
		Data data = new Data();
		int result = searchAppService.save(searchapp);
		if(result>0){
			data.setCode(1);
		}else if(-100==result){
			data.setCode(-100);
		}else
			data.setCode(0);
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(SearchApp searchapp,boolean flagNoUpdateCurrnetData){
		Data data = new Data();
		int result = searchAppService.update(searchapp,flagNoUpdateCurrnetData);
		if(result>0){
			data.setCode(1);
		}else if(-100==result){
			data.setCode(-100);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 删除信息 **/
	@RequestMapping(value="/delete")
	@ResponseBody
	public Data delete(SearchApp searchapp){
		Data data = new Data();
		int result = searchAppService.delete(searchapp);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

