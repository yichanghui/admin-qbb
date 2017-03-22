package com.hiveview.entity.client;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Version {

	private Integer cvId;
	private String version;
	private Timestamp updateTime;
	private Integer type;
	private String features;
	private String url;
	private Integer isEffective;
	private BigInteger cpChannelId;
	
	private Long size;
	private String MD5;
	public Integer getCvId() {
		return cvId;
	}
	public void setCvId(Integer cvId) {
		this.cvId = cvId;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public BigInteger getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(BigInteger cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(Long size) {
		this.size = size;
	}
	public String getMD5() {
		return MD5;
	}
	public void setMD5(String mD5) {
		MD5 = mD5;
	}
}
