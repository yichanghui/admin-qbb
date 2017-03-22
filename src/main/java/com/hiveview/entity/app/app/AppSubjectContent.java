package com.hiveview.entity.app.app;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class AppSubjectContent extends AjaxPage{
	
	//columns START
	private Integer seq;
	private Long subjectId;
	private Long appId;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Long isEffective;
	//columns END

	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	public Integer getSeq() {
		return this.seq;
	}
	public void setSubjectId(Long value) {
		this.subjectId = value;
	}
	
	public Long getSubjectId() {
		return this.subjectId;
	}
	public void setAppId(Long value) {
		this.appId = value;
	}
	
	public Long getAppId() {
		return this.appId;
	}
	public void setCreatedTime(Timestamp value) {
		this.createdTime = value;
	}
	
	public Timestamp getCreatedTime() {
		return this.createdTime;
	}
	public void setUpdatedTime(Timestamp value) {
		this.updatedTime = value;
	}
	
	public Timestamp getUpdatedTime() {
		return this.updatedTime;
	}
	public void setIsEffective(Long value) {
		this.isEffective = value;
	}
	
	public Long getIsEffective() {
		return this.isEffective;
	}

}

