package com.hiveview.action.app.version;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hiveview.entity.app.AppVersion;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.service.app.version.AppVersionService;
import com.hiveview.util.FileUtil;
import com.hiveview.util.StringUtil;

@Controller
@RequestMapping("/appVersion")
public class AppVersionAction{

	@Autowired
	private AppVersionService appVersionService;
	
	@RequestMapping(value="/getAppVersionList", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAppVersionList(AppVersion appVersion,AjaxPage pageAjax){
		ScriptPage scriptPage=new ScriptPage();
		try {
			scriptPage.setRows(this.appVersionService.getAppVersionList(appVersion,pageAjax.getSkipNo(),pageAjax.getPageSize()));
			scriptPage.setTotal(this.appVersionService.getCount(appVersion));
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value="/getAppVersionById", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public AppVersion getAppVersionById(int id){
		try {
			AppVersion appVersion = new AppVersion();
			appVersion.setId(id);
			return this.appVersionService.getAppVersionById(appVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value="/update", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data update(AppVersion appVersion,boolean isNewVersion,String propKey,HttpServletRequest request){
		String url = StringUtil.getNewString(appVersion.getVersionUrl(),getPathForProperties(propKey));
		//判断文件是否存在
		if(new File(url).exists()){
			//String url = "E:\\youku_38.apk";
			appVersion.setMD5(FileUtil.getFileMD5String(url));
			long size = FileUtil.getFileSizes(url);
			if(-1!=size){
				appVersion.setMD5(FileUtil.getFileMD5String(url));
				appVersion.setSize(size);
			}
	        double d = size;
	        d = d/1024/1024;
	        BigDecimal b = new BigDecimal(d);  
	        d = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
	        appVersion.setAppSize(String.valueOf(d)+"M");
		}
		try {
			if(this.appVersionService.update(request,isNewVersion,appVersion)>0){
				return new Data();
			}else{
				return new Data(0,"修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"修改失败"+e.getMessage());
		}
	}
	
	@RequestMapping(value="save", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data save(AppVersion appVersion,boolean isNewVersion,String propKey,HttpServletRequest request){
		String url = StringUtil.getNewString(appVersion.getVersionUrl(),getPathForProperties(propKey));
//				(getPathForProperties(propKey),Constants.APK,false)+StringUtil.getNewString(appVersion.getVersionUrl(),"temp",true);
		//String url = "E:\\youku_38.apk";
		if(new File(url).exists()){
			appVersion.setMD5(FileUtil.getFileMD5String(url));
			long size = FileUtil.getFileSizes(url);
			appVersion.setSize(size);
			
	        double d = size;
	        d = d/1024/1024;
	        BigDecimal b = new BigDecimal(d);  
	        d = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue(); 
	        appVersion.setAppSize(String.valueOf(d)+"M");
		}
        
		try {
			if(this.appVersionService.save(request,isNewVersion,appVersion)>0){
				return new Data();
			}else{
				return new Data(1,"修改失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(1,"修改失败"+e.getMessage());
		}
	}
	
	@RequestMapping(value="delete", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data delete(Integer id){
		try {
			if(this.appVersionService.delete(id)>0){
				return new Data();
			}else{
				return new Data(0,"删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new Data(0,"删除失败"+e.getMessage());
		}
	}
	
	//文件存储路径
	public String getPathForProperties(String key){
		Properties prop = new Properties();// 属性集合对象
		InputStream fis = getClass().getResourceAsStream("/conf.properties");// 属性文件流
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}// 将属性文件流装载到Properties对象中
		return prop.getProperty(key);
	}
	//获得文件名
	public String getFileSuffixName(String url){
		return url.substring(url.lastIndexOf("/")+1,url.length());
	}
}
