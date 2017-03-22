package com.hiveview.entity.app.app;

public class SearchApp{
	
	//columns START
	private Integer id;
	private Integer sequence;
	private java.lang.Integer appId;
	private java.lang.String bundleId;
	private Integer appType;
	private java.lang.String appIcon;
	private java.lang.String appName;
	private java.sql.Timestamp updateTime;
	private Integer isEffective;
	private Integer categoryId;
	//columns END

	public void setSequence(Integer value) {
		this.sequence = value;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSequence() {
		return this.sequence;
	}
	public void setAppId(java.lang.Integer value) {
		this.appId = value;
	}
	public java.lang.Integer getAppId() {
		return this.appId;
	}
	public void setBundleId(java.lang.String value) {
		this.bundleId = value;
	}
	
	public java.lang.String getBundleId() {
		return this.bundleId;
	}
	public void setAppType(Integer value) {
		this.appType = value;
	}
	
	public Integer getAppType() {
		return this.appType;
	}
	public void setAppIcon(java.lang.String value) {
		this.appIcon = value;
	}
	
	public java.lang.String getAppIcon() {
		return this.appIcon;
	}
	public void setAppName(java.lang.String value) {
		this.appName = value;
	}
	public java.lang.String getAppName() {
		return this.appName;
	}
	public void setUpdateTime(java.sql.Timestamp value) {
		this.updateTime = value;
	}
	public java.sql.Timestamp getUpdateTime() {
		return this.updateTime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
}

