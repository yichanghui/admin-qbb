package com.hiveview.entity.client;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class Hardware extends AjaxPage{
	
	//columns START
	private Long id;
	private Long cpId;
	private String hardwareNo;
	private Integer isEffective;
	private Timestamp createTime;
	private Timestamp updateTime;
	//columns END
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCpId() {
		return cpId;
	}
	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}
	public String getHardwareNo() {
		return hardwareNo;
	}
	public void setHardwareNo(String hardwareNo) {
		this.hardwareNo = hardwareNo;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}

