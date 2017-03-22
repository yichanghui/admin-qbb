package com.hiveview.entity.bo.client;

public class VersionUpdateBo {
	private Integer id;
	private Integer cvid;
	private Integer cpId;
	private String cpName;
	private Integer cpChannelId;
	private String cpChannelName;
	private String hardwareId;
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
	public Integer getCpId() {
		return cpId;
	}
	public void setCpId(Integer cpId) {
		this.cpId = cpId;
	}
	public Integer getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Integer cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public String getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(String hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public String getCpChannelName() {
		return cpChannelName;
	}
	public void setCpChannelName(String cpChannelName) {
		this.cpChannelName = cpChannelName;
	}
}
