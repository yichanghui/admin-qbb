package com.hiveview.entity.vo.client;

import com.hiveview.entity.client.Tv;

public class CpChannelTvVo {

	private Long cpChannelId;
	private Integer isEffective;
	private Integer tvId;
	private Tv tv;
	
	public Long getCpChannelId() {
		return cpChannelId;
	}
	public void setCpChannelId(Long cpChannelId) {
		this.cpChannelId = cpChannelId;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public Integer getTvId() {
		return tvId;
	}
	public void setTvId(Integer tvId) {
		this.tvId = tvId;
	}
	public Tv getTv() {
		return tv;
	}
	public void setTv(Tv tv) {
		this.tv = tv;
	}
}
