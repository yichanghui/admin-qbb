package com.hiveview.action.biling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.biling.PricePkg;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.biling.PricePkgService;
@Controller
@RequestMapping("/pricepkg")
public class PricePkgAction{

	@Autowired
	private PricePkgService pricePkgService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("biling/pricepkg_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(PricePkg pricepkg){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = pricePkgService.getList(pricepkg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(PricePkg pricepkg){
		Data data = new Data();
		int result = pricePkgService.save(pricepkg);
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
	public Data update(PricePkg pricepkg){
		Data data = new Data();
		int result = pricePkgService.update(pricepkg);
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
	public Data delete(PricePkg pricepkg){
		Data data = new Data();
		int result = pricePkgService.delete(pricepkg);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

