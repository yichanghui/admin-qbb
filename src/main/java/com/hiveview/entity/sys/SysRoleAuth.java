package com.hiveview.entity.sys;

import java.math.BigInteger;

public class SysRoleAuth {

	private BigInteger roleAuth;
	
	private BigInteger authId;
	
	private BigInteger roleId;

	public BigInteger getRoleAuth() {
		return roleAuth;
	}

	public void setRoleAuth(BigInteger roleAuth) {
		this.roleAuth = roleAuth;
	}

	public BigInteger getAuthId() {
		return authId;
	}

	public void setAuthId(BigInteger authId) {
		this.authId = authId;
	}

	public BigInteger getRoleId() {
		return roleId;
	}

	public void setRoleId(BigInteger roleId) {
		this.roleId = roleId;
	}
	
}
