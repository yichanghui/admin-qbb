package com.hiveview.dao.sys;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.sys.SysAuth;

public interface SysAuthDao extends BaseDao<SysAuth> {

	/**
	 * 获得页面左侧菜单
	 * @param pid
	 * @return
	 */
	public List<SysAuth> getSysAuthByPid(int roleId);
	
	public List<SysAuth> getAllSysAuth();
	
	public List<SysAuth> getSysAuth_All(Map<String,Object> map);
	
	/**
	 * 修改权限
	 * @param sysAuth
	 * @return
	 */
	public int updateSysAuth(SysAuth sysAuth);
	
	/**
	 * 添加权限
	 * @param sysAuth
	 * @return
	 */
	public int addSysAuth(SysAuth sysAuth);
	
	public List<SysAuth> getLeftAuth(Integer roleId);
	
	public List<SysAuth> getParentAuth();
}
