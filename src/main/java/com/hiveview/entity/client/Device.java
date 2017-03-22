package com.hiveview.entity.client;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class Device extends AjaxPage{

	private Long id;
	private String deviceId;
	private String deviceMac;
	private Integer deviceState;
	private String deviceVersion;
	private Timestamp deviceCreateTime;
	private Timestamp deviceLastTime;
	private String deviceLastIp;
	private Long cpChannelId;
	private Long cpId;
	private String deviceSn;
	private String romVersion;
	private Long hardwareId;
	
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
	public Timestamp getDeviceCreateTime() {
		return deviceCreateTime;
	}
	public void setDeviceCreateTime(Timestamp deviceCreateTime) {
		this.deviceCreateTime = deviceCreateTime;
	}
	public Timestamp getDeviceLastTime() {
		return deviceLastTime;
	}
	public void setDeviceLastTime(Timestamp deviceLastTime) {
		this.deviceLastTime = deviceLastTime;
	}
	public String getDeviceLastIp() {
		return deviceLastIp;
	}
	public void setDeviceLastIp(String deviceLastIp) {
		this.deviceLastIp = deviceLastIp;
	}
	public Long getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Long cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public Long getCpId() {
		return cpId;
	}
	public void setCpId(Long cpId) {
		this.cpId = cpId;
	}
	public String getDeviceSn() {
		return deviceSn;
	}
	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}
	public String getRomVersion() {
		return romVersion;
	}
	public void setRomVersion(String romVersion) {
		this.romVersion = romVersion;
	}
	public Long getHardwareId() {
		return hardwareId;
	}
	public void setHardwareId(Long hardwareId) {
		this.hardwareId = hardwareId;
	}
}
