package com.hiveview.service.app.developer;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiveview.dao.app.developer.DeveloperMapper;
import com.hiveview.entity.app.AppDeveloper;
import com.hiveview.util.DateUtil;

@Repository
public class DeveloperService {

	@Autowired
	private DeveloperMapper developerMapper;
	
	public List<AppDeveloper> getDeveloperList(AppDeveloper appDeveloper,Integer currentPage,Integer pageSize){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("developer", appDeveloper);
			map.put("currentPage", currentPage);
			map.put("pageSize", pageSize);
			return this.developerMapper.getAllByPage("AppDeveloperMapper.getDeveloperList", map);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public AppDeveloper getDeveloperById(Integer id){
		try {
			return this.developerMapper.getInfoById("AppDeveloperMapper.Developer", id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer update(AppDeveloper appDeveloper){
		try {
			appDeveloper.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			return this.developerMapper.updateById("AppDeveloperMapper.update", appDeveloper);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer save(AppDeveloper appDeveloper){
		try {
			appDeveloper.setCreateTime(DateUtil.getTimeStamp(new Date()));
			return this.developerMapper.saveInfo("AppDeveloperMapper.save", appDeveloper);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer delete(Integer id){
		try {
			AppDeveloper appDeveloper = new AppDeveloper();
			appDeveloper.setId(id);
			appDeveloper.setState(0);
			return this.developerMapper.updateById("AppDeveloperMapper.update", appDeveloper);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer getCount(AppDeveloper appDeveloper){
		try {
			return this.developerMapper.getCount("AppDeveloperMapper.getCount", appDeveloper);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
