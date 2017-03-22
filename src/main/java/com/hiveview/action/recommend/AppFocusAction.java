
package com.hiveview.action.recommend;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.App;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.AppFocus;
import com.hiveview.service.app.AppService;
import com.hiveview.service.recommend.AppFocusService;
@Controller
@RequestMapping("/appfocus")
public class AppFocusAction{

	@Autowired
	private AppFocusService appFocusService;
	@Autowired
	private AppService appService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recommend/appfocus_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(AppFocus appfocus,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appFocusService.getList(appfocus,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(AppFocus appfocus){
		Data data = new Data();
		int result = appFocusService.save(appfocus);
		if(result>0){
			data.setCode(1);
		}else if(result==-100){
			data.setCode(-100);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(AppFocus appfocus,boolean flagNoUpdateCurrnetData){
		Data data = new Data();
		int result = appFocusService.update(appfocus,flagNoUpdateCurrnetData);
		if(result>0){
			data.setCode(1);
		}else if(result==-100){
			data.setCode(-100);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 删除信息 **/
	@RequestMapping(value="/delete")
	@ResponseBody
	public Data delete(AppFocus appfocus){
		Data data = new Data();
		int result = appFocusService.delete(appfocus);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	@RequestMapping(value="/getAppListForAppfocus")
	@ResponseBody
	public ScriptPage getAppListForAppfocus(App app,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("appName", app.getAppName());
			map.put("categoryId", app.getCategoryId());
			map.put("currentPage", ajaxPage.getSkipNo());
			map.put("pageSize", ajaxPage.getPageSize());
			scriptPage.setRows(appService.getAppList("getAppListForAppfocus",map));
			scriptPage.setTotal(appService.getAppListCount("getAppListForAppfocusCount",map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
}

