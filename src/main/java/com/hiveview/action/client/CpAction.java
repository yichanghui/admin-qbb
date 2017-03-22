package com.hiveview.action.client;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.Cp;
import com.hiveview.service.client.CpService;

@Controller
@RequestMapping("/cp")
public class CpAction{

	@Autowired
	private CpService cpService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/cp_list");
		return mv;
	}
	/**
	 * cp下拉列表
	 * @param pageAjax
	 * @param version
	 * @return
	 */
	@RequestMapping(value="/getCpList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getCpList(AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		List<Cp> cpnList = cpService.getCpList(map);
		scriptPage.setRows(cpnList);
		scriptPage.setTotal(cpnList.size());
		return scriptPage;
	}
	
	@RequestMapping(value="/getCpByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getCpByPage(AjaxPage pageAjax,Cp cp){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("cp", cp);
		List<Cp> cpList = cpService.getCpByPage(map);
		scriptPage.setRows(cpList);
		scriptPage.setTotal(cpService.getCount(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateCp", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateCp(Cp cp){
		int num=cpService.update(cp);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveCp", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveCp(Cp cp){
		int num=cpService.save(cp);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"保存失败");
		}
	}
	
	@RequestMapping(value="/deleteCp", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteCp(Long cpId){
		Cp cp = new Cp();
		cp.setCpId(cpId);
		cp.setCpState(0);
		int num=cpService.delete(cp);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
	/**
	 * 通过设备表获得所有的厂商
	 */
	@RequestMapping(value="/getCpByDeviceByCpChannelId", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data getCpByDeviceByCpChannelId(String cpchannelIds){
		Data data = new Data();
		try {
			data.setObj(cpService.getCpByDeviceByCpChannelId(cpchannelIds));
			data.setCode(1);
		} catch (Exception e) {
			e.printStackTrace();
			data.setCode(0);
		}
		return data;
	}
}
