package com.hiveview.entity.video;

public class VideosetCast{
	
	//columns START
	private java.lang.Integer castId;
	private Integer castType;
	private java.lang.Integer videosetId;
	private java.lang.String castName;
	
	//columns END

	public VideosetCast(){
	}

	public VideosetCast(
		java.lang.Integer castId,
		Integer castType,
		java.lang.Integer videosetId
	){
		this.castId = castId;
		this.castType = castType;
		this.videosetId = videosetId;
	}

	public void setCastId(java.lang.Integer value) {
		this.castId = value;
	}
	
	public java.lang.Integer getCastId() {
		return this.castId;
	}
	public void setCastType(Integer value) {
		this.castType = value;
	}
	
	public Integer getCastType() {
		return this.castType;
	}
	public void setVideosetId(java.lang.Integer value) {
		this.videosetId = value;
	}
	
	public java.lang.Integer getVideosetId() {
		return this.videosetId;
	}
	public void setCastName(java.lang.String value) {
		this.castName = value;
	}
	
	public java.lang.String getCastName() {
		return this.castName;
	}
}

