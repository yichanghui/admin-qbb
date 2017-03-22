package com.hiveview.entity.bluray;

public class CastPhotos{
	
	//columns START
	private Integer photoId;
	private String photoDesc;
	private Integer castType;
	private Integer castId;
	private String photoUrl;
	//columns END
	//冗余演员姓名
	private String castName;
	public String getCastName() {
		return castName;
	}
	public void setCastName(String castName) {
		this.castName = castName;
	}
	public Integer getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Integer photoId) {
		this.photoId = photoId;
	}
	public String getPhotoDesc() {
		return photoDesc;
	}
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}
	public Integer getCastType() {
		return castType;
	}
	public void setCastType(Integer castType) {
		this.castType = castType;
	}
	public Integer getCastId() {
		return castId;
	}
	public void setCastId(Integer castId) {
		this.castId = castId;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
}

