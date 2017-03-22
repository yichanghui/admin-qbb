package com.hiveview.entity.sys;

import java.sql.Timestamp;

public class SysAuth {

	private Integer authId;
	private String authName;
	private String authAction;
	private Integer authSeq;
	private Integer pid;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Integer isEffective;
	
	public Integer getAuthId() {
		return authId;
	}
	public void setAuthId(Integer authId) {
		this.authId = authId;
	}
	public String getAuthName() {
		return authName;
	}
	public void setAuthName(String authName) {
		this.authName = authName;
	}
	public String getAuthAction() {
		return authAction;
	}
	public void setAuthAction(String authAction) {
		this.authAction = authAction;
	}
	public Integer getAuthSeq() {
		return authSeq;
	}
	public void setAuthSeq(Integer authSeq) {
		this.authSeq = authSeq;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
}
