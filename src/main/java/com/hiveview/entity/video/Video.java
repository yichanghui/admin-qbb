package com.hiveview.entity.video;

import java.sql.Timestamp;

public class Video {
	
	private Long videoId;
	private Integer sequence;
	private Long videosetId;
	private String videoName;
	private String videoImg;
	private String videoFocus;
	private String videoBrief;
	private String keyWord;
	private String cpVideoId;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isEffective;
	private Integer videoType;
	private Integer contentType;
	private Long columnId;
	
	private Integer year;
	private String phase;
	private String season;
	private Long playLength;
	
	private Integer episode;
	
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
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
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getCpVideosetId() {
		return cpVideoId;
	}
	public void setCpVideosetId(String cpVideoId) {
		this.cpVideoId = cpVideoId;
	}
	public String getCpVideoId() {
		return cpVideoId;
	}
	public void setCpVideoId(String cpVideoId) {
		this.cpVideoId = cpVideoId;
	}
	public String getPhase() {
		return phase;
	}
	public void setPhase(String phase) {
		this.phase = phase;
	}
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Long getPlayLength() {
		return playLength;
	}
	public void setPlayLength(Long playLength) {
		this.playLength = playLength;
	}
	public Integer getEpisode() {
		return episode;
	}
	public void setEpisode(Integer episode) {
		this.episode = episode;
	}
	
}
