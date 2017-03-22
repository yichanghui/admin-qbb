package com.hiveview.entity.vo.client;

import com.hiveview.entity.client.Device;

public class DeviceVo extends Device {
	
	private String cpName;
	private String cpChannelName;
	private String hardwareNo;
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
	public String getHardwareNo() {
		return hardwareNo;
	}
	public void setHardwareNo(String hardwareNo) {
		this.hardwareNo = hardwareNo;
	}
}
