package com.hiveview.action.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.common.Msg;
import com.hiveview.entity.app.WeatherWallpaper;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.WeatherWallpaperService;

/**
 * 天气图标用户
 * @author gonglixun
 */

@Controller
@RequestMapping("/weatherWallpaper")
public class WeatherWallpaperAction{
	private static final Logger LOG = Logger.getLogger(WeatherWallpaperAction.class.getName());
	
	@Autowired
	private WeatherWallpaperService weatherWallpaperService;
	
	@RequestMapping(value="/getWeatherWallpaperList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getWeatherIconList(WeatherWallpaper weatherWallpaper,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("currentPage",pageAjax.getSkipNo());
			map.put("pageSize", pageAjax.getPageSize());
			map.put("weatherWallpaper", weatherWallpaper);
			List<WeatherWallpaper> weatherWallpaperList =  weatherWallpaperService.getVersionByPage(map);
			scriptPage.setRows(weatherWallpaperList);
			scriptPage.setTotal(weatherWallpaperService.getCount(map));
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(Msg.GET_SYSUSER_ERROE);
			return null;
		}
	}
	
	@RequestMapping("/updateWeatherWallpaper")
	@ResponseBody
	public Data updateWeatherWallpaper(WeatherWallpaper weatherWallpaper){
		if(weatherWallpaperService.update(weatherWallpaper)>0){
			return new Data(1,"");
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping("/addWeatherWallpaper")
	@ResponseBody
	public Data addWeatherWallpaper(WeatherWallpaper weatherWallpaper){
		if(weatherWallpaperService.save(weatherWallpaper)>0){
			return new Data(1,"");
		}else{
			return new Data(0,"添加失败");
		}
	}
	@RequestMapping("/deleteWeatherWallpaper")
	@ResponseBody
	public Data deleteWeatherWallpaper(Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		if(weatherWallpaperService.delete(map)>0){
			return new Data(1,"");
		}else{
			return new Data(0,"删除失败");
		}
	}
}