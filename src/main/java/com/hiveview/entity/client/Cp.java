package com.hiveview.entity.client;

import java.sql.Timestamp;
import java.util.List;

import com.hiveview.entity.bo.client.HardwareBo;

public class Cp {

	private Long cpId;
	private Integer cpChannelId;
	private String cpName;
	private List<HardwareBo> hardware;
	private Timestamp cpCreateTime;
	private Integer cpState;

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
	public Timestamp getCpCreateTime() {
		return cpCreateTime;
	}
	public void setCpCreateTime(Timestamp cpCreateTime) {
		this.cpCreateTime = cpCreateTime;
	}
	public Integer getCpState() {
		return cpState;
	}
	public void setCpState(Integer cpState) {
		this.cpState = cpState;
	}

	public Integer getCpChannelId() {
		return cpChannelId;
	}

	public void setCpChannelId(Integer cpChannelId) {
		this.cpChannelId = cpChannelId;
	}

	public List<HardwareBo> getHardware() {
		return hardware;
	}

	public void setHardware(List<HardwareBo> hardware) {
		this.hardware = hardware;
	}

}
