package com.hiveview.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hiveview.common.Msg;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.sys.SysUser;
import com.hiveview.service.sys.SysAuthService;
import com.hiveview.service.sys.SysUserService;


@Controller
@RequestMapping("")
public class LoginAction {

	@Autowired
	SysUserService sysUserService;
	@Autowired
	SysAuthService sysAuthService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "common/welcome";
	}

	@RequestMapping(value = "/loginChecksession", method = RequestMethod.POST)
	public Data loginChecksession(HttpServletRequest req) {
		if(req.getSession().getAttribute("currentUser") != null)
			return new Data(1,"");
		else
			return new Data(0,"会话没有信息，已经退出登录！");
	}
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest req,SysUser sysUser) {
		try {
			if(null==sysUser||null==sysUser.getUserMail()||null==sysUser.getUserPwd()){
				req.setAttribute("loginInfo","");
				return "login";
			}
			SysUser currentUser = sysUserService.getLoginInfo(sysUser);
			if(null==currentUser){
				req.setAttribute("loginInfo","用户名和密码错误！");
				return "login";
			}else{
				HttpSession session = req.getSession();
				session.setAttribute("currentUser", currentUser);
				String sessionId = session.getId();
				
				//登录用户的信息放到application
				ServletContext application = session.getServletContext();
				Msg.getInstance().put(currentUser.getUserId().toString(),sessionId);
				application.setAttribute("sessionIdMap",Msg.sessionIdMap);
				req.setAttribute("leftMeau",sysAuthService.getLeftAuth(currentUser.getRoleId()));
				return "index";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@RequestMapping(value = "/logout")
	public String exit(HttpServletRequest request) {
		request.setAttribute("loginInfo","");
		request.getSession().invalidate();
		return "login";
	}
	@RequestMapping(value = "/index2")
	public String index2(HttpServletRequest request) {
		return "index2";
	}

}
