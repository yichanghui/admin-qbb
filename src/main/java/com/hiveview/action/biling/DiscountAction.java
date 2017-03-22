package com.hiveview.action.biling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.biling.Discount;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.biling.DiscountService;

@Controller
@RequestMapping("/discount")
public class DiscountAction {

	@Autowired
	private DiscountService discountService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("biling/discount_list");
		return mv;
	}
		
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")	
	@ResponseBody
	public ScriptPage getList(Discount discount,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = discountService.getList(discount, ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	
	/** 添加信息 **/
	@RequestMapping(value="/save")
	@ResponseBody
	public Data save(Discount discount){
		Data data = new Data();
		int result = discountService.save(discount);
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
	public Data update(Discount discount){
		Data data = new Data();
		int result = discountService.update(discount);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	/** 删除信息 **/
	
}
