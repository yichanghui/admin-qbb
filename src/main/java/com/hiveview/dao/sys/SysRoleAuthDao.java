package com.hiveview.dao.sys;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.sys.SysRoleAuth;

/**
 * @author gonglixun
 */
@Repository
public interface SysRoleAuthDao extends BaseDao<SysRoleAuth> {
	
	/**
	 * 添加
	 * @param sysRoleAuth
	 * @return
	 */
	public int addRoleAuth(SysRoleAuth sysRoleAuth);
	
	/**
	 * 删除
	 * @param roleId
	 * @return
	 */
	public int deleteRoleAuth(BigInteger roleId);
}
