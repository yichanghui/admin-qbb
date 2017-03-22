package com.hiveview.entity.client;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class DeviceLog extends AjaxPage{
	
	//columns START
	private Long id;
	private String deviceId;
	private String deviceSn;
	private String deviceMac;
	private Integer deviceState;
	private String deviceVersion;
	private Long cpId;
	private String cpName;
	private Long hardwareId;
	private String hardwareNo;
	private Long cpChannelId;
	private String cpChannelName;
	private String romVersion;
	private Timestamp createTime;
	//columns END
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public String getDeviceMac() {
		return deviceMac;
	}
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	public Integer getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(Integer deviceState) {
		this.deviceState = deviceState;
	}
	public String getDeviceVersion() {
		return deviceVersion;
	}
	public void setDeviceVersion(String deviceVersion) {
		this.deviceVersion = deviceVersion;
	}
	public Long getCpId() {
		return cpId;
	}
	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public Long getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(Long hardwareId) {
		this.hardwareId = hardwareId;
	}
	public String getHardwareNo() {
		return hardwareNo;
	}
	public void setHardwareNo(String hardwareNo) {
		this.hardwareNo = hardwareNo;
	}
	public Long getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Long cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public String getCpChannelName() {
		return cpChannelName;
	}
	public void setCpChannelName(String cpChannelName) {
		this.cpChannelName = cpChannelName;
	}
	public String getRomVersion() {
		return romVersion;
	}
	public void setRomVersion(String romVersion) {
		this.romVersion = romVersion;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}

