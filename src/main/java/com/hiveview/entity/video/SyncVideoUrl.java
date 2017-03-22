package com.hiveview.entity.video;

import java.sql.Timestamp;

public class SyncVideoUrl {
	  private Integer videoType;
	 private String videoId;
	 private String videoUrlM3u8Normal;
	 private String videoUrlM3u8Middle;
	 private String videoUrlM3u8High;
	 private String videoUrlNp4Normal;
	 private String videoUrlMp4Middle;
	 private String videoUrlMp4High;
	 private Timestamp  updateTime;
	 private Integer isEffective;
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoUrlM3u8Normal() {
		return videoUrlM3u8Normal;
	}
	public void setVideoUrlM3u8Normal(String videoUrlM3u8Normal) {
		this.videoUrlM3u8Normal = videoUrlM3u8Normal;
	}
	public String getVideoUrlM3u8Middle() {
		return videoUrlM3u8Middle;
	}
	public void setVideoUrlM3u8Middle(String videoUrlM3u8Middle) {
		this.videoUrlM3u8Middle = videoUrlM3u8Middle;
	}
	public String getVideoUrlM3u8High() {
		return videoUrlM3u8High;
	}
	public void setVideoUrlM3u8High(String videoUrlM3u8High) {
		this.videoUrlM3u8High = videoUrlM3u8High;
	}
	public String getVideoUrlNp4Normal() {
		return videoUrlNp4Normal;
	}
	public void setVideoUrlNp4Normal(String videoUrlNp4Normal) {
		this.videoUrlNp4Normal = videoUrlNp4Normal;
	}
	public String getVideoUrlMp4Middle() {
		return videoUrlMp4Middle;
	}
	public void setVideoUrlMp4Middle(String videoUrlMp4Middle) {
		this.videoUrlMp4Middle = videoUrlMp4Middle;
	}
	public String getVideoUrlMp4High() {
		return videoUrlMp4High;
	}
	public void setVideoUrlMp4High(String videoUrlMp4High) {
		this.videoUrlMp4High = videoUrlMp4High;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}

}
