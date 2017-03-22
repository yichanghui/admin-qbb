package com.hiveview.service.sys;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hiveview.dao.sys.SysAuthDao;
import com.hiveview.entity.bo.AjaxPage;
import com.hiveview.entity.bo.ScriptPage;
import com.hiveview.entity.sys.SysAuth;

@Service
public class SysAuthService {
	@Autowired
	private SysAuthDao sysAuthMapper;
	/**
	 * 获取用户权限
	 * @param pid
	 * @return
	 */
	public List<SysAuth> getSysAuthByRoleId(int roleId){
		try {
			if(roleId!=-1){
				return sysAuthMapper.getSysAuthByPid(roleId);
			}else{
				return sysAuthMapper.getAllSysAuth();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取所有权限
	 * @return
	 */
	public ScriptPage getSysAuthAll(SysAuth sysAuth,AjaxPage ajaxPage){
		ScriptPage scriptPage = new ScriptPage();
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			if(sysAuth!=null){
				if(null!=sysAuth.getAuthName()){
					map.put("authName", sysAuth.getAuthName());
				}
				if(null!=sysAuth.getPid()){
					map.put("pid", sysAuth.getPid());
				}
			}
			map.put("currentPage", ajaxPage.getSkipNo());
			map.put("pageSize", ajaxPage.getPageSize());
			List<SysAuth> rows = sysAuthMapper.getSysAuth_All(map);
			scriptPage.setRows(rows);
			int total = sysAuthMapper.getCount(sysAuth);
			scriptPage.setTotal(total);
			return scriptPage;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 修改系统权限
	 * @param sysAuth
	 * @return
	 */
	public int updateSysAuth(SysAuth sysAuth){
		try {
			sysAuth.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
			return sysAuthMapper.updateSysAuth(sysAuth);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 添加系统权限
	 * @param sysAuth
	 * @return
	 */
	public int addSysAuth(SysAuth sysAuth){
		try {
			sysAuth.setCreatedTime(new Timestamp(System.currentTimeMillis()));
			sysAuth.setUpdatedTime(new Timestamp(System.currentTimeMillis()));
			return sysAuthMapper.addSysAuth(sysAuth);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 逻辑删除系统权限
	 * @param authId
	 * @return
	 */
	public int deleteSysAuth(int authId){
		try {
			SysAuth auth = new SysAuth();
			auth.setAuthId(authId);
			auth.setIsEffective(0);
			return sysAuthMapper.updateSysAuth(auth);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	/**
	 * 查询数量
	 * @param sysAuth
	 * @return
	 */
	public int getCount(SysAuth sysAuth){
		try {
			return sysAuthMapper.getCount(sysAuth);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	public List<SysAuth> getLeftAuth(Integer roleId){
		return sysAuthMapper.getLeftAuth(roleId);
	}
	
	public List<SysAuth> getParentAuth(){
		return sysAuthMapper.getParentAuth();
	}
}
