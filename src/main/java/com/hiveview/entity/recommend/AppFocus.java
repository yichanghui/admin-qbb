package com.hiveview.entity.recommend;

public class AppFocus{
	
	//columns START
	private java.lang.Integer id;
	private Integer position;
	private Integer navigationId;
	private Integer seq;
	private java.lang.Integer contentType;
	private java.lang.Long contentId;
	private java.lang.String contentDesc;
	private java.lang.String focusLargeImg;
	private java.lang.String focusThumbImg;
	private java.lang.String contentName;
	private java.lang.Integer intervalTime;
	private java.sql.Timestamp createdTime;
	private java.sql.Timestamp updatedTime;
	private java.lang.Long isEffective;
	//columns END

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setPosition(Integer value) {
		this.position = value;
	}
	
	public Integer getPosition() {
		return this.position;
	}
	public void setNavigationId(Integer value) {
		this.navigationId = value;
	}
	
	public Integer getNavigationId() {
		return this.navigationId;
	}
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	public Integer getSeq() {
		return this.seq;
	}
	public void setContentType(java.lang.Integer value) {
		this.contentType = value;
	}
	
	public java.lang.Integer getContentType() {
		return this.contentType;
	}
	public void setContentId(java.lang.Long value) {
		this.contentId = value;
	}
	
	public java.lang.Long getContentId() {
		return this.contentId;
	}
	public void setContentDesc(java.lang.String value) {
		this.contentDesc = value;
	}
	
	public java.lang.String getContentDesc() {
		return this.contentDesc;
	}
	public void setFocusLargeImg(java.lang.String value) {
		this.focusLargeImg = value;
	}
	
	public java.lang.String getFocusLargeImg() {
		return this.focusLargeImg;
	}
	public void setFocusThumbImg(java.lang.String value) {
		this.focusThumbImg = value;
	}
	
	public java.lang.String getFocusThumbImg() {
		return this.focusThumbImg;
	}
	public void setContentName(java.lang.String value) {
		this.contentName = value;
	}
	
	public java.lang.String getContentName() {
		return this.contentName;
	}
	public void setIntervalTime(java.lang.Integer value) {
		this.intervalTime = value;
	}
	
	public java.lang.Integer getIntervalTime() {
		return this.intervalTime;
	}
	public void setCreatedTime(java.sql.Timestamp value) {
		this.createdTime = value;
	}
	
	public java.sql.Timestamp getCreatedTime() {
		return this.createdTime;
	}
	public void setUpdatedTime(java.sql.Timestamp value) {
		this.updatedTime = value;
	}
	
	public java.sql.Timestamp getUpdatedTime() {
		return this.updatedTime;
	}
	public void setIsEffective(java.lang.Long value) {
		this.isEffective = value;
	}
	
	public java.lang.Long getIsEffective() {
		return this.isEffective;
	}

}

