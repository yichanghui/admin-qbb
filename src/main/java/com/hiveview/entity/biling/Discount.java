package com.hiveview.entity.biling;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class Discount extends AjaxPage{

	//columns START
	private Integer discountId;	
	private String discountName;	
	private Integer state;	
	private Timestamp createTime;	
	private Timestamp updateTime;
	//columns END
	
	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}


	
}
