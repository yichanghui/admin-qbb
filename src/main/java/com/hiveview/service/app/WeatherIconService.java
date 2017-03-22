package com.hiveview.service.app;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.app.WeatherIocnMapper;
import com.hiveview.entity.app.WeatherIcon;
import com.hiveview.util.DateUtil;

@Service
public class WeatherIconService{
	
	@Autowired
	private WeatherIocnMapper weatherIocnMapper;

	public List<WeatherIcon> getVersionByPage(Map<String, Object> map){
		try {
			List<WeatherIcon> list=weatherIocnMapper.getAllByPage("WeatherIocnMapper.getVersionByPage", map);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public int getCount(Map<String, Object> map){
		try {
			return weatherIocnMapper.getCountByPage("WeatherIocnMapper.getCount", map);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		}
	}
	
	public int save(WeatherIcon weatherIcon){
		try {
			weatherIcon.setCreateTime(DateUtil.getTimeStamp(new Date()));
			return weatherIocnMapper.saveInfo("WeatherIocnMapper.add", weatherIcon);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public int update(WeatherIcon weatherIcon){
		try {
			weatherIcon.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			return weatherIocnMapper.updateById("WeatherIocnMapper.update", weatherIcon);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		
	}
}
