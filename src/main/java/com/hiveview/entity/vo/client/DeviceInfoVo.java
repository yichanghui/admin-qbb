package com.hiveview.entity.vo.client;

import com.hiveview.entity.client.Cp;
import com.hiveview.entity.client.CpChannel;
import com.hiveview.entity.client.Hardware;


public class DeviceInfoVo {

	private Long id;
	private String deviceId;
	private String deviceSn;
	private String deviceMac;
	private Integer deviceState;
	private String deviceVersion;
	private Long cpChannelId;
	private Long cpId;
	private String romVersion;
	private Long hardwareId;
	
	private Cp cp;
	private CpChannel cpChannel;
	private Hardware hardware;
	
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
	public Cp getCp() {
		return cp;
	}
	public void setCp(Cp cp) {
		this.cp = cp;
	}
	public CpChannel getCpChannel() {
		return cpChannel;
	}
	public void setCpChannel(CpChannel cpChannel) {
		this.cpChannel = cpChannel;
	}
	public Hardware getHardware() {
		return hardware;
	}
	public void setHardware(Hardware hardware) {
		this.hardware = hardware;
	}
}
