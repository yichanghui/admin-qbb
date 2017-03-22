package com.hiveview.dao.app;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseMapper;
import com.hiveview.entity.app.App;
import com.hiveview.entity.app.AppTagRelate;

@Repository
public class AppMapper extends BaseMapper<App> {
	
	
	public Integer saveAppTagRelate(AppTagRelate relate){
		return this.getSqlSession().insert("AppMapper.saveAppTagRelate", relate);
	}
	
	public List<App> getAppListClassify(Map<String,Object> map){
		return this.getSqlSession().selectList("AppMapper.getAppListClassify", map);
	}
	public Integer getAppListClassifyCount(Map<String,Object> map){
		return this.getSqlSession().selectOne("AppMapper.getAppListClassifyCount", map);
	}
	public App getAppInfo(App app){
		return this.getSqlSession().selectOne("AppMapper.getAppInfo",app);
	}
	
	/**
	 * 查询应用时过滤掉已经存在的应用
	 * @param mybatisSQLName
	 * @param map
	 * @return
	 */
	public List<App> getAppList(String mybatisSQLName,Map<String,Object> map){
		return this.getSqlSession().selectList("AppMapper."+mybatisSQLName, map);
	}
	public Integer getAppListCount(String mybatisSQLName,Map<String,Object> map){
		return this.getSqlSession().selectOne("AppMapper."+mybatisSQLName, map);
	}
}
