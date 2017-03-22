package com.hiveview.entity.app.app;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class AppTop extends AjaxPage{
	
	//columns START
	private Integer seq;
	private Integer appId;
	private Integer topType;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Long isEffective;
	private Long categoryId;
	private Integer oldAppId;
	private Integer oldTopType;
	//columns END
	
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getAppId() {
		return appId;
	}
	public void setAppId(Integer appId) {
		this.appId = appId;
	}
	public Integer getTopType() {
		return topType;
	}
	public void setTopType(Integer topType) {
		this.topType = topType;
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
	public Long getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Long isEffective) {
		this.isEffective = isEffective;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public Integer getOldAppId() {
		return oldAppId;
	}
	public void setOldAppId(Integer oldAppId) {
		this.oldAppId = oldAppId;
	}
	public Integer getOldTopType() {
		return oldTopType;
	}
	public void setOldTopType(Integer oldTopType) {
		this.oldTopType = oldTopType;
	}
}

