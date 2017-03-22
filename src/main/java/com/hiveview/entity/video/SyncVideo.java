package com.hiveview.entity.video;

import java.sql.Timestamp;

public class SyncVideo {
	private String videoId;
	private String videosetId;
	private String videoName;
	private String videoImg;
	private String videoFocus;
	private String videoBrief;
	private String keyWord;
	private Long videoidSource;
	private String videoUrlM3u8Normal;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer cp;
	private Integer isEffective;
	private Integer videoType;
	
	private Integer contentType;
	
	private Long columnId;

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getVideosetId() {
		return videosetId;
	}

	public void setVideosetId(String videosetId) {
		this.videosetId = videosetId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoImg() {
		return videoImg;
	}

	public void setVideoImg(String videoImg) {
		this.videoImg = videoImg;
	}

	public String getVideoFocus() {
		return videoFocus;
	}

	public void setVideoFocus(String videoFocus) {
		this.videoFocus = videoFocus;
	}

	public String getVideoBrief() {
		return videoBrief;
	}

	public void setVideoBrief(String videoBrief) {
		this.videoBrief = videoBrief;
	}

	public String getKeyWord() {
		return keyWord;
	}

	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}

	public Long getVideoidSource() {
		return videoidSource;
	}

	public void setVideoidSource(Long videoidSource) {
		this.videoidSource = videoidSource;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public Integer getIsEffective() {
		return isEffective;
	}

	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}

	public Integer getVideoType() {
		return videoType;
	}

	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}

	public String getVideoUrlM3u8Normal() {
		return videoUrlM3u8Normal;
	}

	public void setVideoUrlM3u8Normal(String videoUrlM3u8Normal) {
		this.videoUrlM3u8Normal = videoUrlM3u8Normal;
	}

	public Integer getContentType() {
		return contentType;
	}

	public void setContentType(Integer contentType) {
		this.contentType = contentType;
	}

	public Long getColumnId() {
		return columnId;
	}

	public void setColumnId(Long columnId) {
		this.columnId = columnId;
	}

}
