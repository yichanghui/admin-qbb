package com.hiveview.dao.sys;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.sys.SysRole;

/**
 * @author gonglixun
 */
@Repository
public interface SysRoleDao extends BaseDao<SysRole> {

	/**
	 * 查找所有的角色
	 * @param map
	 * @return
	 */
	public List<SysRole> getSysRole_All(Map<String, Object> map);
	
	/**
	 * 修改系统角色
	 * @param sysRole
	 * @return
	 */
	public int updateSysRole(SysRole sysRole);
	
	/**
	 * 添加系统角色
	 * @param sysRole
	 * @return
	 */
	public int addSysRole(SysRole sysRole);
	/**
	 * 删除
	 * @param roleId
	 * @return
	 */
	public int deleteRole(BigInteger roleId);
}
