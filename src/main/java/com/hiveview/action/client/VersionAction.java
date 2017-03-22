package com.hiveview.action.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.client.Version;
import com.hiveview.entity.po.client.VersionUpdatePo;
import com.hiveview.service.client.VersionService;
import com.hiveview.util.FileUtil;
import com.hiveview.util.StringUtil;

@Controller
@RequestMapping("/version")
public class VersionAction{

	@Autowired
	private VersionService versionService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("client/version_list");
		return mv;
	}
	@RequestMapping(value="/getVersionByPage", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getVersionByPage(AjaxPage pageAjax,Version version){
		ScriptPage scriptPage=new ScriptPage();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("currentPage",pageAjax.getSkipNo());
		map.put("pageSize", pageAjax.getPageSize());
		map.put("version", version);
		List<Version> versionList = versionService.getVersionByPage(map);
		scriptPage.setRows(versionList);
		scriptPage.setTotal(versionService.getCount(map));
		return scriptPage;
	}
	
	@RequestMapping(value="/updateVersion", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data updateVersion(Version version,String propKey){
//		String url = StringUtil.getNewString(getPathForProperties(propKey),Constants.APK,false)+StringUtil.getNewString(version.getUrl(),Constants.APK,true);
		String url = StringUtil.getNewString(version.getUrl(),getPathForProperties(propKey));
		//String url = "E:\\youku_38.apk";
		if(new File(url).exists()){
			version.setMD5(FileUtil.getFileMD5String(url));
			long size = FileUtil.getFileSizes(url);
			if(-1!=size){
				version.setMD5(FileUtil.getFileMD5String(url));
				version.setSize(size);
			}
		}
		int num=versionService.updateClassFirst(version);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"修改失败");
		}
	}
	
	@RequestMapping(value="/saveVersion", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data saveVersion(Version version,String propKey){
		String url = StringUtil.getNewString(version.getUrl(),getPathForProperties(propKey));  
		//String url = "E:\\youku_38.apk";
		if(new File(url).exists()){
			version.setMD5(FileUtil.getFileMD5String(url));
			long size = FileUtil.getFileSizes(url);
			version.setSize(size);
		}
		int num=versionService.save(version);
		if(num==1){
			return new Data();
		}else{
			return new Data(0,"添加失败");
		}
	}
	
	@RequestMapping(value="/deleteVersion", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public Data deleteVersion(Long cvId){
		int num=versionService.deleteSysVersion(cvId);
		if(num>=1){
			return new Data();
		}else{
			return new Data(0,"删除失败");
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
				return null;
			}// 将属性文件流装载到Properties对象中
			return prop.getProperty(key);
		}
		//获得文件名
		public String getFileSuffixName(String url){
			return url.substring(url.lastIndexOf("/")+1,url.length());
		}
		
		@RequestMapping(value="/getCpListForSelect", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data getCpListForSelect(){
			Data data = new Data();
			data.setObj(versionService.getCpListForSelect());
			return data;
		}
		
		@RequestMapping(value="/getCpChannelForVersion", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ScriptPage getCpChannelForVersion(VersionUpdatePo versionUpdatePo){
			return versionService.getCpChannelForVersion(versionUpdatePo);
		}

		//sys_version_update 表 操作
		@RequestMapping(value="/getVersionUpdateByPage", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public ScriptPage getVersionUpdateByPage(VersionUpdatePo versionUpdatePo){
			return versionService.getVersionUpdateByPage(versionUpdatePo);
		}
		@RequestMapping(value="/addSysVersionUpdate", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data addSysVersionUpdate(VersionUpdatePo versionUpdatePo){
			if(versionService.addSysVersionUpdate(versionUpdatePo)>0){
				return new Data();
			}
			return new Data(0,"sys error");
		}
		@RequestMapping(value="/deleteSysVersionUpdate", produces ={"application/json;charset=UTF-8"})
		@ResponseBody
		public Data deleteSysVersionUpdate(Integer id){
			if(versionService.deleteSysVersionUpdate(id)>0){
				return new Data();
			}
			return new Data(0,"sys error");
		}
}
