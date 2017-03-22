package com.hiveview.entity.client;

import java.math.BigInteger;
import java.sql.Timestamp;

public class CpChannel {

	private Long cpChannelId;
	private String cpChannelName;
	private Timestamp cpCreateTime;
	private Integer cpChannelState;
	
	private String secretKey;
	private BigInteger maxSize;
	
	private Integer isCheckMac;
	private String cpChannelLogo;

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

	public Timestamp getCpCreateTime() {
		return cpCreateTime;
	}

	public void setCpCreateTime(Timestamp cpCreateTime) {
		this.cpCreateTime = cpCreateTime;
	}

	public Integer getCpChannelState() {
		return cpChannelState;
	}

	public void setCpChannelState(Integer cpChannelState) {
		this.cpChannelState = cpChannelState;
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public BigInteger getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(BigInteger maxSize) {
		this.maxSize = maxSize;
	}

	public Integer getIsCheckMac() {
		return isCheckMac;
	}

	public void setIsCheckMac(Integer isCheckMac) {
		this.isCheckMac = isCheckMac;
	}

	public String getCpChannelLogo() {
		return cpChannelLogo;
	}

	public void setCpChannelLogo(String cpChannelLogo) {
		this.cpChannelLogo = cpChannelLogo;
	}

}
