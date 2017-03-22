package com.hiveview.entity.vo.biling;

import com.hiveview.entity.biling.Discount;

public class DiscountVo extends Discount{

	//columns START
	private Integer discountId;	
	private String discountName;	
	private Integer state;
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

}
