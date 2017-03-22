package com.hiveview.action.app.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.App;
import com.hiveview.entity.app.AppDeveloper;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.developer.DeveloperService;

@Controller
@RequestMapping("/appdeveloper")
public class DeveloperAction {

	@Autowired
	private DeveloperService developerService;
	
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/developer/developer_list");
		return mv;
	}
	
	@RequestMapping(value="/getDeveloperList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getDeveloperList(AppDeveloper appDeveloper,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			scriptPage.setRows(this.developerService.getDeveloperList(appDeveloper,pageAjax.getSkipNo(),pageAjax.getPageSize()));
			scriptPage.setTotal(this.developerService.getCount(appDeveloper));
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/getDeveloperById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public AppDeveloper getDeveloperById(int appId){
		try {
			App app = new App();
			app.setAppId(appId);
			return this.developerService.getDeveloperById(appId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/update", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data update(AppDeveloper appDeveloper){
		try {
			if(this.developerService.update(appDeveloper)>0){
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
	public Data save(AppDeveloper appDeveloper){
		try {
			if(this.developerService.save(appDeveloper)>0){
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
			if(this.developerService.delete(id)>0){
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
