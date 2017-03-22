package com.hiveview.entity.recommend;

import java.sql.Timestamp;

public class Focus{
	
	//columns START
	private Integer id;
	private Integer position;
	private Integer seq;
	private Integer contentType;
	private Long contentId;
	private String contentDesc;
	private String focusLargeImg;
	private String focusThumbImg;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Long isEffective;
	private String contentName;
	private String contentTypeName;
	private Integer intervalTime;
	//columns END
	
	public Integer getSeq() {
		return seq;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public Integer getContentType() {
		return contentType;
	}
	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}
	public Long getContentId() {
		return contentId;
	}
	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}
	public String getContentDesc() {
		return contentDesc;
	}
	public void setContentDesc(String contentDesc) {
		this.contentDesc = contentDesc;
	}
	public String getFocusLargeImg() {
		return focusLargeImg;
	}
	public void setFocusLargeImg(String focusLargeImg) {
		this.focusLargeImg = focusLargeImg;
	}
	public String getFocusThumbImg() {
		return focusThumbImg;
	}
	public void setFocusThumbImg(String focusThumbImg) {
		this.focusThumbImg = focusThumbImg;
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
	public String getContentName() {
		return contentName;
	}
	public void setContentName(String contentName) {
		this.contentName = contentName;
	}
	public String getContentTypeName() {
		return contentTypeName;
	}
	public void setContentTypeName(String contentTypeName) {
		this.contentTypeName = contentTypeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIntervalTime() {
		return intervalTime;
	}
	public void setIntervalTime(Integer intervalTime) {
		this.intervalTime = intervalTime;
	}
}

