package com.hiveview.dao.sys;

import java.math.BigInteger;

import org.springframework.stereotype.Repository;

import com.hiveview.dao.BaseDao;
import com.hiveview.entity.sys.SysUserSession;

@Repository
public interface SysUserSessionDao extends BaseDao<SysUserSession> {

	public int addUserSession(SysUserSession sysUserSession);

	public SysUserSession getSysUserSessionBySessionId(BigInteger sessionId);
	
	public int updateSysUserSessionBySessionId(SysUserSession sysUserSession);
	
}
