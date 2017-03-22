package com.hiveview.entity.app;

import java.sql.Timestamp;

public class AppOperateHistory {

	private Integer id;
	private Timestamp operateTime;
	private String account;
	private Integer appId;
	private String operateRecord;
	private Integer operateType;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getOperateTime() {
		return operateTime;
	}
	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public String getOperateRecord() {
		return operateRecord;
	}
	public void setOperateRecord(String operateRecord) {
		this.operateRecord = operateRecord;
	}
	public Integer getOperateType() {
		return operateType;
	}
	public void setOperateType(Integer operateType) {
		this.operateType = operateType;
	}
}
