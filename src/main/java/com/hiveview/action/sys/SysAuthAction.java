package com.hiveview.action.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.sys.SysAuth;
import com.hiveview.entity.sys.SysUser;
import com.hiveview.service.sys.SysAuthService;

@Controller
@RequestMapping("/sysAuth")
public class SysAuthAction {
	
	static Logger logger = Logger.getLogger(SysAuthAction.class);

	@Autowired
	private SysAuthService sysAuthService;
//	/**
//	 * 左侧菜单列表
//	 * @return
//	 */
//	@RequestMapping(value="/getAuthByPid", produces ={"application/json;charset=UTF-8"})
//	@ResponseBody
//	public String getAuthByPid(HttpServletRequest req){
//		try {
//			SysUser sysUser = (SysUser)req.getSession().getAttribute("currentUser");
//			int roleId = sysUser.getRoleId();
//			//List<SysAuth> sysAuthList = Msg.getList();
//			PageAjax pageAjax = null;
//			//if(null==sysAuthList){
//			//	sysAuthList =  sysAuthService.getSysAuthByRoleId(roleId);
//			//	Msg.setLeftMeau(sysAuthList);
//			//	System.out.println("sysAuthList is null...");
//			//}
//			List<SysAuth> sysAuthList =  sysAuthService.getSysAuthByRoleId(roleId);
//			pageAjax = new PageAjax(-1, -1, -1, sysAuthList);
//			return this.setJSONObject(pageAjax);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return this.setJSONObject(null);
//		}
//	}
//	
	/**
	 * 修改权限
	 * @param roleId
	 * @return
	 */
	@RequestMapping(value="/getAuthByRoleId", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAuthByRoleId(int roleId){
		ScriptPage scriptPage = new ScriptPage();
		List<SysAuth> sysAuthList =  sysAuthService.getSysAuthByRoleId(roleId);
		scriptPage.setRows(sysAuthList);
		return scriptPage;
	}
	
	@RequestMapping(value="/getAllAuthToTree", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAllAuthToTree(){
		ScriptPage scriptPage = new ScriptPage();
		List<SysAuth> sysAuthList =  sysAuthService.getSysAuthByRoleId(-1);
		scriptPage.setRows(sysAuthList);
		return scriptPage;
	}
	
	@RequestMapping(value="/getParentAuth", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getParentAuth(){
		ScriptPage scriptPage = new ScriptPage();
		List<SysAuth> sysAuthList =  sysAuthService.getParentAuth();
		scriptPage.setRows(sysAuthList);
		return scriptPage;
	}
	/**
	 * 权限列表管理（分页查询所有）
	 * @param sysAuth
	 * @param pageAjax
	 * @return
	 */
	@RequestMapping(value="/getAuthForAll", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getAuthForAll(SysAuth sysAuth,AjaxPage ajaxPage){
		return sysAuthService.getSysAuthAll(sysAuth,ajaxPage);
	}
	
	@RequestMapping("/updateSysAuth")
	@ResponseBody
	public Data updateSysAuth(SysAuth sysAuth){
		Data data = new Data();
		int i = sysAuthService.updateSysAuth(sysAuth);
		if(i>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}

	@RequestMapping("/addSysAuth")
	@ResponseBody
	public Data addSysAuth(SysAuth sysAuth){
		Data data = new Data();
		if(sysAuthService.addSysAuth(sysAuth)>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
//	
//	@RequestMapping("/deleteSysAuth")
//	@ResponseBody
//	public String deleteSysAuth(int authId){
//		if(sysAuthService.deleteSysAuth(authId)>0){
//			return setJSONObject(SUCCESS);
//		}else{
//			return setJSONObject(ERROR);
//		}
//	}
//	
	@RequestMapping(value = "/getLeftAuth")
	@ResponseBody
	public ScriptPage getLeftAuth(HttpServletRequest req){
		ScriptPage scriptPage = new ScriptPage();
		try {
			SysUser user= (SysUser)req.getSession().getAttribute("currentUser");
			if(null!=user){
				scriptPage.setRows(sysAuthService.getLeftAuth(user.getRoleId()));
			}else{
				logger.info("###ERROR##########您还没有登录...#############ERROR###");
			}
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			return scriptPage;
		}
	}
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/auth_list");
		return mv;
	}
}
