package com.hiveview.action.client;

import java.math.BigInteger;
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
import com.hiveview.entity.client.CpChannel;
import com.hiveview.service.client.CpChannelService;

@Controller
@RequestMapping("/cpChannel")
public class CpChannelAction{
	@Autowired
	private CpChannelService cpChannelService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/cpChannel_list");
		return mv;
	}
	
	@RequestMapping(value="/getCpChannelByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getCpChannelByPage(AjaxPage pageAjax,CpChannel cpChannel){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("cpChannel", cpChannel);
		List<CpChannel> cpChannelList = cpChannelService.getCpChannelByPage(map);
		scriptPage.setRows(cpChannelList);
		scriptPage.setTotal(cpChannelService.getCount(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateCpChannel", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateCpChannel(CpChannel cpChannel){
		int num=cpChannelService.update(cpChannel);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveCpChannel", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveCpChannel(CpChannel cpChannel){
		int num=cpChannelService.save(cpChannel);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"添加失败");
		}
	}
	
	@RequestMapping(value="/deleteCpChannel", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteCpChannel(Long cpChannelId){
		CpChannel cpChannel = new CpChannel();
		cpChannel.setCpChannelId(cpChannelId);
		cpChannel.setCpChannelState(0);
		int num=cpChannelService.update(cpChannel);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
		}
	}
	
	@RequestMapping(value="/getCpChannelCountBycpId", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public String getCpChannelCountBycpId(BigInteger cpId){
		Map<String, Object> map = new HashMap<String, Object>();
		CpChannel cpChannel = new CpChannel();
		cpChannel.setCpChannelState(1);
		map.put("cpChannel", cpChannel);
		
		Integer num=cpChannelService.getCount(map);
		return num==0?"0":num.toString();
	}
}
