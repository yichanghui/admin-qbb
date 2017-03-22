package com.hiveview.entity.client;

import com.hiveview.entity.bo.AjaxPage;

public class CpChannelTv extends AjaxPage{
	
	//columns START
	private java.lang.Integer cpChannelId;
	private java.lang.Integer tvId;
	private java.lang.Boolean isEffective;
	//columns END

	public void setCpChannelId(java.lang.Integer value) {
		this.cpChannelId = value;
	}
	
	public java.lang.Integer getCpChannelId() {
		return this.cpChannelId;
	}
	public void setTvId(java.lang.Integer value) {
		this.tvId = value;
	}
	
	public java.lang.Integer getTvId() {
		return this.tvId;
	}
	public void setIsEffective(java.lang.Boolean value) {
		this.isEffective = value;
	}
	
	public java.lang.Boolean getIsEffective() {
		return this.isEffective;
	}

}

