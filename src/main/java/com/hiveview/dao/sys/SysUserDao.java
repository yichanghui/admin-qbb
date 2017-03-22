package com.hiveview.dao.sys;

import java.util.List;
import java.util.Map;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.sys.SysUser;

public interface SysUserDao extends BaseDao<SysUser> {

	/**
	 * 通过Id获取系统用户信息
	 * @param sysUser
	 * @return
	 */
	public SysUser getSysUserById(int userId);

	/**
	 * 获取所有系统用户信息
	 * @param sysUser
	 * @return
	 */
	public List<SysUser> getSysUserByAll(Map<String,Object> map);

	/**
	 * 登录
	 * @param sysUser
	 * @return
	 */
	public SysUser getLoginInfo(SysUser sysUser);
	
	/**
	 * 保存系统用户信息
	 * @param sysUser
	 * @return
	 */
	public int addSysUser(SysUser sysUser);
	
	
	/**
	 * 更新系统用户信息
	 * @param sysUser
	 * @return
	 */
	public int updateSysUser(SysUser sysUser);
	
	/**
	 * 分页查询用户信息
	 * @param map
	 * @return
	 */
	public List<SysUser> getUserList(Map<String,Object> map);
	
	public Integer deleteSysUserById(Integer sysUserById);
	
}
