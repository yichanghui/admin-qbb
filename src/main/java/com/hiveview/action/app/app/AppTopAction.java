package com.hiveview.action.app.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.App;
import com.hiveview.entity.app.app.AppTop;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.AppService;
import com.hiveview.service.app.app.AppTopService;
@Controller
@RequestMapping("/apptop")
public class AppTopAction{

	@Autowired
	private AppTopService appTopService;
	@Autowired
	private AppService appService;
	
	/**
	 * 显示应用排行榜
	 * @return
	 */
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/app/appTop_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(AppTop apptop,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appTopService.getList(apptop,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/**
	 * 榜单列表详情
	 * @param apptop
	 * @param ajaxPage
	 * @return
	 */
	@RequestMapping(value="/getAppTopList")
	@ResponseBody
	public ScriptPage getAppTopList(AppTop apptop,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appTopService.getAppTopList(apptop,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(AppTop apptop){
		Data data = new Data(0,"");
		try {
			int result = appTopService.save(apptop);
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
	public Data update(AppTop apptop){
		Data data = new Data(0,"");
		try {
			int result = appTopService.update(apptop);
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
	public Data delete(AppTop apptop){
		Data data = new Data();
		int result = appTopService.delete(apptop);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping(value="/getAppListForApptop")
	@ResponseBody
	public ScriptPage getAppListForApptop(App app,Integer topType,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("appName", app.getAppName());
			map.put("categoryId", app.getCategoryId());
			map.put("topType", topType);
			map.put("currentPage", ajaxPage.getSkipNo());
			map.put("pageSize", ajaxPage.getPageSize());
			scriptPage.setRows(appService.getAppList("getAppListForApptop",map));
			scriptPage.setTotal(appService.getAppListCount("getAppListForApptopCount",map));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
}

