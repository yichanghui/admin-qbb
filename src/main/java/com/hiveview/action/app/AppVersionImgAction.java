package com.hiveview.action.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.vo.app.AppVersionImg;
import com.hiveview.service.app.AppVersionImgService;
@Controller
@RequestMapping("/appversionimg")
public class AppVersionImgAction{

	@Autowired
	private AppVersionImgService appVersionImgService;
	
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(AppVersionImg appversionimg,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = appVersionImgService.getList(appversionimg,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(AppVersionImg appversionimg){
		Data data = new Data();
		int result = appVersionImgService.save(appversionimg);
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
	public Data update(AppVersionImg appversionimg){
		Data data = new Data();
		int result = appVersionImgService.update(appversionimg);
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
	public Data delete(AppVersionImg appversionimg){
		Data data = new Data();
		int result = appVersionImgService.delete(appversionimg);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

