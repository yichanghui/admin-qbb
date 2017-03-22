package com.hiveview.action.sys;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.Data;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.sys.SysRole;
import com.hiveview.entity.sys.SysRoleAuth;
import com.hiveview.service.sys.SysRoleService;

@Controller
@RequestMapping("/sysRole")
public class SysRoleAction{
	
	@Autowired
	private SysRoleService sysRoleService;
	
	@RequestMapping(value = "/show")
	public ModelAndView show(){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("sys/role_list");
		return mv;
	}
	
	@RequestMapping(value="/getSysRole_All", produces ={"application/json;charset=UTF-8"})
	@ResponseBody
	public ScriptPage getSysRole_All(SysRole sysRole,AjaxPage pageAjax){
		ScriptPage scriptPage = new ScriptPage();
		int currentPage = pageAjax.getPageIndex();
		int pageSize = pageAjax.getPageSize();
		List<SysRole> rows = this.sysRoleService.getSysRole_All(sysRole, currentPage, pageSize);
		int total = sysRoleService.getCount(sysRole);
		scriptPage.setRows(rows);
		scriptPage.setTotal(total);
		return scriptPage;
	} 
	
	@RequestMapping("/updateSysRole")
	@ResponseBody
	public Data updateSysRole(SysRole sysRole,String sysRoleAuth){
		Data data = new Data();
		/*** 获得要添加的权限 start ***/
		String authIdArray[] = sysRoleAuth.split(",");
		List<SysRoleAuth> roleAuthlist = new ArrayList<SysRoleAuth>();
		for(int authIdIndex=0;authIdIndex<authIdArray.length;authIdIndex++){
			SysRoleAuth ra = new SysRoleAuth();
			ra.setRoleId(sysRole.getRoleId());
			ra.setAuthId(new BigInteger(authIdArray[authIdIndex]));
			roleAuthlist.add(ra);
		}
		/*** 获得要添加的权限 end ***/
		if(sysRoleService.updateSysRole(sysRole,roleAuthlist)>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping("/addSysRole")
	@ResponseBody
	public Data addSysRole(SysRole sysRole,String sysRoleAuth){
		Data data = new Data();
		//执行添加
		if(sysRoleService.addSysRole(sysRole, sysRoleAuth)>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
	
	@RequestMapping("/deleteRole")
	@ResponseBody
	public Data deleteRole(BigInteger roleId){
		Data data = new Data();
		if(sysRoleService.deleteRole(roleId)>0){
			data.setCode(1);
		}else{
			data.setCode(0);
		}
		return data;
	}
}
