package com.hiveview.action.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;

import com.hiveview.service.client.CpChannelTvService;
import com.hiveview.entity.client.CpChannelTv;
@Controller
@RequestMapping("/cpchanneltv")
public class CpChannelTvAction{

	@Autowired
	private CpChannelTvService cpChannelTvService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/cpchanneltv_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(CpChannelTv cpchanneltv,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = cpChannelTvService.getList(cpchanneltv,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(CpChannelTv cpchanneltv){
		Data data = new Data();
		try {
			int result = cpChannelTvService.save(cpchanneltv);
			if(result>0){
				data.setCode(1);
			}else{
				data.setCode(0);
			}
		} catch (Exception e) {
			data.setCode(0);
			e.printStackTrace();
		}
		return data;
	}
	/** 修改信息 **/
	@RequestMapping(value="/update")
	@ResponseBody
	public Data update(CpChannelTv cpchanneltv){
		Data data = new Data();
		int result = cpChannelTvService.update(cpchanneltv);
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
	public Data delete(CpChannelTv cpchanneltv){
		Data data = new Data();
		int result = cpChannelTvService.delete(cpchanneltv);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}

