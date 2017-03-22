package com.hiveview.entity.po.client;

import com.hiveview.entity.bo.AjaxPage;

public class VersionUpdatePo extends AjaxPage{
	private Integer id;
	private Integer cvid;
	private Integer cpId;
	private Integer cpChannelId;
	private String version;
	private Long hardwareId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCvid() {
		return cvid;
	}
	public void setCvid(Integer cvid) {
		this.cvid = cvid;
	}
	public Integer getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Integer cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Long getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(Long hardwareId) {
		this.hardwareId = hardwareId;
	}
	public Integer getCpId() {
		return cpId;
	}
	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}
}
