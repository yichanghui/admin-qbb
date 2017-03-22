package com.hiveview.action.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.bo.client.CpChannelTvBo;
import com.hiveview.service.client.TvService;
import com.hiveview.entity.client.Tv;
@Controller
@RequestMapping("/tv")
public class TvAction{

	@Autowired
	private TvService tvService;
	
	/** 显示页面 **/
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/tv_list");
		return mv;
	}
	/** 分页查询列表 **/
	@RequestMapping(value="/getList")
	@ResponseBody
	public ScriptPage getList(Tv tv,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = tvService.getList(tv,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	/** 添加信息 **/
	@RequestMapping(value="/add")
	@ResponseBody
	public Data add(Tv tv){
		Data data = new Data();
		int result = tvService.save(tv);
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
	public Data update(Tv tv){
		Data data = new Data();
		int result = tvService.update(tv);
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
	public Data delete(Tv tv){
		Data data = new Data();
		int result = tvService.delete(tv);
		if(result>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	/**
	 * 查询未与当前渠道关联的电视台列表
	 * @param tvBo
	 * @param ajaxPage
	 * @return
	 */
	@RequestMapping(value="/getUnselectList")
	@ResponseBody
	public ScriptPage getUnselectList(CpChannelTvBo tvBo,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = tvService.getUnselectList(tvBo,ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
}

