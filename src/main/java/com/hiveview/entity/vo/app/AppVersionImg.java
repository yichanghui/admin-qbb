package com.hiveview.entity.vo.app;

import com.hiveview.entity.bo.AjaxPage;

public class AppVersionImg extends AjaxPage{
	
	//columns START
	private java.lang.Integer id;
	private Integer seq;
	private java.lang.Integer appId;
	private java.lang.Integer appVersionId;
	private java.lang.String imgUrl;
	private java.lang.String imgSize;
	private java.lang.String imgDesc;
	//columns END

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	public Integer getSeq() {
		return this.seq;
	}
	public void setAppId(java.lang.Integer value) {
		this.appId = value;
	}
	
	public java.lang.Integer getAppId() {
		return this.appId;
	}
	public void setAppVersionId(java.lang.Integer value) {
		this.appVersionId = value;
	}
	
	public java.lang.Integer getAppVersionId() {
		return this.appVersionId;
	}
	public void setImgUrl(java.lang.String value) {
		this.imgUrl = value;
	}
	
	public java.lang.String getImgUrl() {
		return this.imgUrl;
	}
	public void setImgSize(java.lang.String value) {
		this.imgSize = value;
	}
	
	public java.lang.String getImgSize() {
		return this.imgSize;
	}
	public void setImgDesc(java.lang.String value) {
		this.imgDesc = value;
	}
	public java.lang.String getImgDesc() {
		return this.imgDesc;
	}
}

