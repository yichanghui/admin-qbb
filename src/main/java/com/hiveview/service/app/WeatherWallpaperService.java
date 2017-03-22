package com.hiveview.service.app;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.WeatherWallpaperMapper;
import com.hiveview.entity.app.WeatherWallpaper;
import com.hiveview.util.DateUtil;

@Service
public class WeatherWallpaperService{
	
	@Autowired
	private WeatherWallpaperMapper weatherWallpaperMapper;

	public List<WeatherWallpaper> getVersionByPage(Map<String, Object> map){
		try {
			List<WeatherWallpaper> list=weatherWallpaperMapper.getAllByPage("WeatherWallpaperMapper.getWeatherByPage", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return weatherWallpaperMapper.getCountByPage("WeatherWallpaperMapper.getCount", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(WeatherWallpaper weatherWallpaper){
		try {
			weatherWallpaper.setCreateTime(DateUtil.getTimeStamp(new Date()));
			weatherWallpaper.setWallpaperState(1);
			return weatherWallpaperMapper.saveInfo("WeatherWallpaperMapper.add", weatherWallpaper);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int update(WeatherWallpaper weatherWallpaper){
		try {
			weatherWallpaper.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			return weatherWallpaperMapper.updateById("WeatherWallpaperMapper.update", weatherWallpaper);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}

	public int delete(Map<String,Object> map){
		try {
			return weatherWallpaperMapper.delById("WeatherWallpaperMapper.delete", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
}
