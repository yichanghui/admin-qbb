
package com.hiveview.action.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.cache.CacheUrl;
import com.hiveview.service.cache.CacheUrlService;
@Controller
@RequestMapping("/cacheurl")
public class CacheUrlAction{

	@Autowired
	private CacheUrlService cacheUrlService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("cache/cacheurl_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(CacheUrl cacheurl,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = cacheUrlService.getList(cacheurl,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(CacheUrl cacheurl){
		Data data = new Data();
		int result = cacheUrlService.save(cacheurl);
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
	public Data update(CacheUrl cacheurl){
		Data data = new Data();
		int result = cacheUrlService.update(cacheurl);
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
	public Data delete(CacheUrl cacheurl){
		Data data = new Data();
		int result = cacheUrlService.delete(cacheurl);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/** 清除缓存 **/
	@RequestMapping(value="/removeCache")
	@ResponseBody
	public Data removeCache(CacheUrl cacheurl){
		int result = cacheUrlService.removeCache(cacheurl);
		if(result>0){
			return new Data(1,"");
		}else{
			return new Data(0,"");
		}
	}
}

