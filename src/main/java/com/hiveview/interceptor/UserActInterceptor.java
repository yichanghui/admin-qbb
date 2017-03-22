package com.hiveview.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.sys.SysUser;
import com.hiveview.service.log.UserActService;

public class UserActInterceptor implements HandlerInterceptor {

	@Autowired
	private UserActService service; 

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		if (request.getSession().getAttribute("currentUser") != null) {
			service.LogAct(
					(SysUser) request.getSession().getAttribute("currentUser"),
					request.getServletPath(), request.getParameterMap());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}
}
