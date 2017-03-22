package com.hiveview.action.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.app.WeatherIcon;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.WeatherIconService;

/**
 * 天气图标用户
 * @author gonglixun
 */

@Controller
@RequestMapping("/weatherIcon")
public class WeatherIconAction{
	private static final Logger LOG = Logger.getLogger(WeatherIconAction.class.getName());
	
	@Autowired
	private WeatherIconService weatherIconService;
	
	@RequestMapping(value="/show")
	public ModelAndView show() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("app/weatherIcon_list");
		return mv;
	}
	
	@RequestMapping(value="/getWeatherIconList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getWeatherIconList(WeatherIcon weatherIcon,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("currentPage",pageAjax.getSkipNo());
			map.put("pageSize", pageAjax.getPageSize());
			map.put("weatherIcon", weatherIcon);
			List<WeatherIcon> weatherIconList =  weatherIconService.getVersionByPage(map);
			scriptPage.setRows(weatherIconList);
			scriptPage.setTotal(weatherIconService.getCount(map));
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e.getMessage());
			return null;
		}
	}
	
	@RequestMapping("/updateWeatherIcon")
	@ResponseBody
	public Data updateSysUserById(WeatherIcon weatherIcon){
		if(weatherIconService.update(weatherIcon)>0){
			return new Data(1,"");
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping("/addWeatherIcon")
	@ResponseBody
	public Data addWeatherIcon(WeatherIcon weatherIcon){
		if(weatherIconService.save(weatherIcon)>0){
			return new Data(1,"");
		}else{
			return new Data(0,"添加失败");
		}
	}
}