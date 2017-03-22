package com.hiveview.entity.video;

import java.sql.Timestamp;

public class SyncVideoSet {
	private String videosetId;
	private String videosetName;
	private String videosetFocus;
	private String videosetBrief;
	private Integer videosetType;
	private Integer videosetTotal;
	private String videosetImg;
	private String keyWord;
	private String isSuetime;
	private String director;
	private String actors;
	private String tag;
	private Timestamp createTime;
	private Timestamp updateTime;
	private Integer isEffective;
	private String cpVideosetId;
	private String pyName;
	private Integer cp;
	public String getVideosetId() {
		return videosetId;
	}
	public void setVideosetId(String videosetId) {
		this.videosetId = videosetId;
	}
	public String getVideosetName() {
		return videosetName;
	}
	public void setVideosetName(String videosetName) {
		this.videosetName = videosetName;
	}
	public String getVideosetFocus() {
		return videosetFocus;
	}
	public void setVideosetFocus(String videosetFocus) {
		this.videosetFocus = videosetFocus;
	}
	public String getVideosetBrief() {
		return videosetBrief;
	}
	public void setVideosetBrief(String videosetBrief) {
		this.videosetBrief = videosetBrief;
	}
	public Integer getVideosetType() {
		return videosetType;
	}
	public void setVideosetType(Integer videosetType) {
		this.videosetType = videosetType;
	}
	public Integer getVideosetTotal() {
		return videosetTotal;
	}
	public void setVideosetTotal(Integer videosetTotal) {
		this.videosetTotal = videosetTotal;
	}
	public String getVideosetImg() {
		return videosetImg;
	}
	public void setVideosetImg(String videosetImg) {
		this.videosetImg = videosetImg;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getIsSuetime() {
		return isSuetime;
	}
	public void setIsSuetime(String isSuetime) {
		this.isSuetime = isSuetime;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
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
	public String getPyName() {
		return pyName;
	}
	public void setPyName(String pyName) {
		this.pyName = pyName;
	}
	public Integer getCp() {
		return cp;
	}
	public void setCp(Integer cp) {
		this.cp = cp;
	}
	public String getCpVideosetId() {
		return cpVideosetId;
	}
	public void setCpVideosetId(String cpVideosetId) {
		this.cpVideosetId = cpVideosetId;
	}

}
