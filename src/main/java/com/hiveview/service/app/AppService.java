package com.hiveview.service.app;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSON;
import com.hiveview.dao.app.AppMapper;
import com.hiveview.entity.app.App;
import com.hiveview.entity.app.AppOperateHistory;
import com.hiveview.entity.app.AppTagRelate;
import com.hiveview.service.app.operatehistory.OperatehistoryService;
import com.hiveview.util.DateUtil;
import com.hiveview.util.PinyinUtil;

@Repository
public class AppService {
	
	@Autowired
	private AppMapper appMapper;
	@Autowired
	private OperatehistoryService operatehistoryService;
	
	private static final Logger LOG = Logger.getLogger(AppService.class);
	
	public List<App> getAppList(App app,Integer currentPage,Integer pageSize){
		try {
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("app", app);
			map.put("currentPage", currentPage);
			map.put("pageSize", pageSize);
			return this.appMapper.getAllByPage("AppMapper.getAppList", map);	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public App getAppById(App app){
		try {
			return this.appMapper.getInfoById("AppMapper.getAppById", app);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer update(final HttpServletRequest request,App app){
		try {
			app.setPyName(PinyinUtil.getFirstHanyuPinyin(app.getAppName()));
			app.setUpdateTime(DateUtil.getTimeStamp(new Date()));
			if(this.appMapper.updateById("AppMapper.update", app)>0){
				AppOperateHistory history = new AppOperateHistory();
				history.setAppId(app.getAppId());
				history.setOperateRecord("修改应用："+app.getAppName()+"│"+(app.getAppType()==1?"一般应用":"系统应用")+"│"+(app.getIsPay()==1?"收费":"免费")+"│"+(app.getState()==1?"有效":"<span style=color:red;>无效</span>"));
				executeThreadForAppRelateTag(request,history,app);
				return 1;
			}else{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer save(final HttpServletRequest request,App app){
		try {
			app.setPyName(PinyinUtil.getFirstHanyuPinyin(app.getAppName()));
			app.setCreateTime(DateUtil.getTimeStamp(new Date()));
			Integer appId = this.appMapper.saveInfo("AppMapper.save", app);
			if(appId>0){
				AppOperateHistory history = new AppOperateHistory();
				history.setAppId(app.getAppId());
				history.setOperateRecord("添加应用："+app.getAppName()+"│"+(app.getAppType()==1?"一般应用":"系统应用")+"│"+(app.getIsPay()==1?"收费":"免费")+"│"+(app.getState()==1?"有效":"<span style=color:red;>无效</span>"));
				executeThreadForAppRelateTag(request,history,app);
				return appId;
			}else{
				return -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	public Integer delete(Integer id){
		try {
			App app = new App();
			app.setAppId(id);
			return this.appMapper.updateById("AppMapper.delete", app);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Integer getCount(App app){
		try {
			return this.appMapper.getCount("AppMapper.getCount", app);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<App> getAppList(String mybatisSQLName,Map<String,Object> map){
		return this.appMapper.getAppList(mybatisSQLName, map);
	}
	public int getAppListCount(String mybatisSQLName,Map<String,Object> map){
		return this.appMapper.getAppListCount(mybatisSQLName, map);
	}
	
	private void executeThreadForAppRelateTag(HttpServletRequest request,final AppOperateHistory history,final App app){
		final HttpSession session = request.getSession();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				LOG.info("开始关联标签--->先删除存在的关联标签...");
				appMapper.delById("AppMapper.deleteAppTagRelate", app);
				LOG.info("删除成功--->开始运行添加标签...");
				List<AppTagRelate> list = JSON.parseArray(app.getTagInfo(),AppTagRelate.class);
				for(AppTagRelate relate:list){
					relate.setAppId(app.getAppId());
					LOG.info("添加成功--->关联标签成功!!!");
					appMapper.saveAppTagRelate(relate);
				}
				
				history.setOperateType(1);
				operatehistoryService.save(session,history);
				
			}
		});
		thread.start();
	}
}