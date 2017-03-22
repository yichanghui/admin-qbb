
package com.hiveview.action.recommend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.recommend.ModuleSkin;
import com.hiveview.service.recommend.ModuleSkinService;
@Controller
@RequestMapping("/moduleskin")
public class ModuleSkinAction{

	@Autowired
	private ModuleSkinService moduleSkinService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("recommend/moduleSkin_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(ModuleSkin backgroundrecom,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = moduleSkinService.getList(backgroundrecom,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(ModuleSkin moduleSkin){
		Data data = new Data();
		try {
			int result = moduleSkinService.save(moduleSkin);
			if(result>0){
				data.setCode(1);
			}else{
				data.setCode(0);
			}
			return data;
		} catch (Exception e) {
			data.setCode(-1);
			data.setMsg("推荐位类型已经存在！");
			return data;
		}
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(ModuleSkin moduleSkin){
		Data data = new Data();
		int result = moduleSkinService.update(moduleSkin);
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
	public Data delete(ModuleSkin backgroundrecom){
		Data data = new Data();
		int result = moduleSkinService.delete(backgroundrecom);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

