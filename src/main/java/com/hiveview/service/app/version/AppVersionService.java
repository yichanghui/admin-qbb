package com.hiveview.service.app.version;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hiveview.dao.app.AppMapper;
import com.hiveview.dao.app.version.AppVersionMapper;
import com.hiveview.entity.app.App;
import com.hiveview.entity.app.AppOperateHistory;
import com.hiveview.entity.app.AppVersion;
import com.hiveview.service.app.operatehistory.OperatehistoryService;
import com.hiveview.util.DateUtil;

@Repository
public class AppVersionService {

	@Autowired
	private AppMapper appMapper;
	@Autowired
	private AppVersionMapper appVersionMapper;
	@Autowired
	private OperatehistoryService operatehistoryService;
	
	public List<AppVersion> getAppVersionList(AppVersion appVersion,Integer currentPage,Integer pageSize){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("appVersion", appVersion);
			map.put("currentPage", currentPage);
			map.put("pageSize", pageSize);
			return this.appVersionMapper.getAllByPage("AppVersionMapper.getAppVersionList", map);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public AppVersion getAppVersionById(AppVersion appVersion){
		try {
			return this.appVersionMapper.getInfoById("AppVersionMapper.getAppVersionById", appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer update(HttpServletRequest request,boolean isNewVersion,AppVersion appVersion){
		try {
			appVersion.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			if(isNewVersion){
				updateAppVersion(appVersion);//修改应用版本
			}
			if(this.appVersionMapper.updateById("AppVersionMapper.update", appVersion)>0){
				AppOperateHistory history = new AppOperateHistory();
				history.setAppId(appVersion.getAppId());
				history.setOperateRecord("修改版本:"+appVersion.getVersionNo());
				executeThreadForVersionOperate(request,history);
				return 1;
			}else{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer save(HttpServletRequest request,boolean isNewVersion,AppVersion appVersion){
		try {
			appVersion.setCreateTime(DateUtil.getTimeStamp(new Date()));
			if(isNewVersion){
				updateAppVersion(appVersion);//修改应用版本
			}
			Integer id = this.appVersionMapper.saveInfo("AppVersionMapper.save", appVersion);
			if(id>0){
				AppOperateHistory history = new AppOperateHistory();
				history.setAppId(appVersion.getAppId());
				history.setOperateRecord("添加新版本:"+appVersion.getVersionNo());
				executeThreadForVersionOperate(request,history);
				return id; 
			}else{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer delete(Integer id){
		try {
			AppVersion appVersion=new AppVersion();
			appVersion.setId(id);
			appVersion.setState(0);
			if(this.appVersionMapper.updateById("AppVersionMapper.delete", appVersion)>0){
				return 1;
			}else{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer getCount(AppVersion appVersion){
		try {
			return this.appVersionMapper.getCount("AppVersionMapper.getCount", appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private void executeThreadForVersionOperate(HttpServletRequest request,final AppOperateHistory history){
		final HttpSession session = request.getSession();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				history.setOperateType(2);
				operatehistoryService.save(session,history);
			}
		});
		thread.start();
	}
	
	private void updateAppVersion(AppVersion appVersion){
			App app = new App();
			app.setAppId(appVersion.getAppId());
			app.setLatestVersion(appVersion.getVersionNo());
			appMapper.updateById("AppMapper.update", app);
	}
}
