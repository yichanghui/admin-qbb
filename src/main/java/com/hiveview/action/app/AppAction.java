package com.hiveview.action.app;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.App;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.AppService;

@Controller
@RequestMapping("/app")
public class AppAction{

	@Autowired
	private AppService appService;
	
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/app_list");
		return mv;
	}
	
	@RequestMapping(value="/getAppList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAppList(App app,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			scriptPage.setRows(this.appService.getAppList(app,pageAjax.getSkipNo(),pageAjax.getPageSize()));
			scriptPage.setTotal(this.appService.getCount(app));
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/getAppById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public App getAppById(int appId){
		try {
			App app = new App();
			app.setAppId(appId);
			return this.appService.getAppById(app);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/update", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data update(App app,HttpServletRequest request){
		try {
			if(this.appService.update(request,app)>0){
				return new Data();
			}else{
				return new Data(0,"修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"修改失败"+e.getMessage());
		}
	}
	
	@RequestMapping(value="/save", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data save(App app,HttpServletRequest request){
		try {
			if(this.appService.save(request,app)>0){
				return new Data();
			}else{
				return new Data(0,"添加失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"添加失败"+e.getMessage());
		}
	}
	
	@RequestMapping(value="/delete", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data delete(Integer id){
		try {
			if(this.appService.delete(id)>0){
				return new Data();
			}else{
				return new Data(0,"删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"删除失败"+e.getMessage());
		}
	}
}
