package com.hiveview.entity.bo.client;

import java.sql.Timestamp;

public class CpChannelTvBo {

	private Integer id;
	private String tvid;
	private String tvname;
	private String tvlogo;
	private Integer sequence;
	private Integer areaLimit;
	private String epgAddress;
	private String mediatype;
	private String liveurl;
	private Integer viewback;
	private Timestamp updatedtime;
	private Integer isEffective;
	private Long cpChannelId;
	private Integer pageIndex;
	private Integer pageSize;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTvid() {
		return tvid;
	}
	public void setTvid(String tvid) {
		this.tvid = tvid;
	}
	public String getTvname() {
		return tvname;
	}
	public void setTvname(String tvname) {
		this.tvname = tvname;
	}
	public String getTvlogo() {
		return tvlogo;
	}
	public void setTvlogo(String tvlogo) {
		this.tvlogo = tvlogo;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getAreaLimit() {
		return areaLimit;
	}
	public void setAreaLimit(Integer areaLimit) {
		this.areaLimit = areaLimit;
	}
	public String getEpgAddress() {
		return epgAddress;
	}
	public void setEpgAddress(String epgAddress) {
		this.epgAddress = epgAddress;
	}
	public String getMediatype() {
		return mediatype;
	}
	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}
	public String getLiveurl() {
		return liveurl;
	}
	public void setLiveurl(String liveurl) {
		this.liveurl = liveurl;
	}
	public Integer getViewback() {
		return viewback;
	}
	public void setViewback(Integer viewback) {
		this.viewback = viewback;
	}
	public Timestamp getUpdatedtime() {
		return updatedtime;
	}
	public void setUpdatedtime(Timestamp updatedtime) {
		this.updatedtime = updatedtime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Long getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Long cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}
