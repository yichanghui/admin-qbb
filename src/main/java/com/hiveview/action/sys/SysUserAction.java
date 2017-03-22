package com.hiveview.action.sys;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.sys.SysUser;
import com.hiveview.service.sys.SysUserService;

@Controller
@RequestMapping("/sysUser")
public class SysUserAction {
	@Autowired
	private SysUserService sysUserService;
	
	@RequestMapping(value = "/getList")
	@ResponseBody
	public ScriptPage getUserList(AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			scriptPage = sysUserService.getSysUserByAll(ajaxPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return scriptPage;
	}
	
	
	@RequestMapping("/updateSysUserById")
	@ResponseBody
	public Data updateSysUserById(SysUser user,HttpServletRequest req){
		Data data = new Data();
		SysUser currentUser = (SysUser)req.getSession().getAttribute("currentUser");
		if(null==currentUser){
			data.setCode(0);
			return data;
		}
		user.setUpdatedBy(currentUser.getUserId());
		if(currentUser.getUserPwd().equals(user.getUserPwd()))
			user.setUserPwd(null);
		int flag =sysUserService.updateSysUser(user);
		if(flag>0){
			data.setCode(1);
		}else if(flag == -1){
			data.setCode(-1);
			data.setMsg("mail_same");
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping("/updateSysUserPwd")
	@ResponseBody
	public Data updateSysUserPwd(String pwd,String newPwd,HttpServletRequest req){
		SysUser currentUser = (SysUser)req.getSession().getAttribute("currentUser");
		SysUser user = new SysUser();
		user.setUserId(currentUser.getUserId());
		user.setUserMail(currentUser.getUserMail());
		user.setUserPwd(newPwd);
		int flag = sysUserService.updateSysUserPwd(pwd,user);
		if(flag>0)
			return new Data(1,"success");
		else if(flag==-100)
			return new Data(-100,"user password is error!");
		else
			return new Data(0,"error");
	} 

	
	@RequestMapping("/addSysUser")
	@ResponseBody
	public Data addSysUser(SysUser user,HttpServletRequest req){
		Data data = new Data();
		SysUser currentUser = (SysUser)req.getSession().getAttribute("currentUser");
		if(null==currentUser){
			data.setCode(0);
			return data;
		}
		user.setCreatedBy(currentUser.getUserId());
		int flag = sysUserService.addSysUser(user);
		if(flag>0){
			data.setCode(1);
		}else if(flag == -1){
			data.setCode(-1);
			data.setMsg("mail_same");
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping(value = "/deleteSysUserById")
	@ResponseBody
	public Data deleteSysUserById(Integer sysUserId){
		Data data = new Data();
		if(this.sysUserService.deleteSysUser(sysUserId)>0){
			return data;
		}
		data.setCode(0);
		return data;
	}
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/user_list");
		return mv;
	}
	
}
