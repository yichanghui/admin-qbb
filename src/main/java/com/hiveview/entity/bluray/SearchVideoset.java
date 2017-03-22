package com.hiveview.entity.bluray;

import java.sql.Timestamp;

public class SearchVideoset{
	
	
	//columns START
	private Integer sequence;
	private Long videosetId;
	private Timestamp updateTime;
	private Boolean isEffective;
	private Long videosetType;
	private String videosetName;
	private String videosetImg;
	//columns END
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Long getVideosetId() {
		return videosetId;
	}
	public void setVideosetId(Long videosetId) {
		this.videosetId = videosetId;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Boolean isEffective) {
		this.isEffective = isEffective;
	}
	public Long getVideosetType() {
		return videosetType;
	}
	public void setVideosetType(Long videosetType) {
		this.videosetType = videosetType;
	}
	public String getVideosetName() {
		return videosetName;
	}
	public void setVideosetName(String videosetName) {
		this.videosetName = videosetName;
	}
	public String getVideosetImg() {
		return videosetImg;
	}
	public void setVideosetImg(String videosetImg) {
		this.videosetImg = videosetImg;
	}
}

