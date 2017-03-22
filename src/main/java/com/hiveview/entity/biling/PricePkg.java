package com.hiveview.entity.biling;

import com.hiveview.entity.bo.AjaxPage;

public class PricePkg extends AjaxPage{
	
	//columns START
	private java.lang.Integer pricePkgId;
	private java.lang.Integer seq;
	private java.lang.String name;
	private java.lang.String pic;
	private java.lang.String priceDesc;
	private java.lang.Integer price;
	private java.lang.Integer vipPrice;
	private java.lang.Integer discountId;
	private java.lang.Integer discountName;
	private java.lang.Integer expiryTime;
	private java.lang.Integer expiryPlay;
	private Integer state;
	private java.sql.Timestamp ctime;
	private java.sql.Timestamp utime;
	//columns END

	public void setPricePkgId(java.lang.Integer value) {
		this.pricePkgId = value;
	}
	
	public java.lang.Integer getPricePkgId() {
		return this.pricePkgId;
	}
	public void setSeq(java.lang.Integer value) {
		this.seq = value;
	}
	
	public java.lang.Integer getSeq() {
		return this.seq;
	}
	public void setName(java.lang.String value) {
		this.name = value;
	}
	
	public java.lang.String getName() {
		return this.name;
	}
	public void setPic(java.lang.String value) {
		this.pic = value;
	}
	
	public java.lang.String getPic() {
		return this.pic;
	}
	public java.lang.String getPriceDesc() {
		return priceDesc;
	}

	public void setPriceDesc(java.lang.String priceDesc) {
		this.priceDesc = priceDesc;
	}

	public void setPrice(java.lang.Integer value) {
		this.price = value;
	}
	
	public java.lang.Integer getPrice() {
		return this.price;
	}
	public void setVipPrice(java.lang.Integer value) {
		this.vipPrice = value;
	}
	
	public java.lang.Integer getVipPrice() {
		return this.vipPrice;
	}
	public void setDiscountId(java.lang.Integer value) {
		this.discountId = value;
	}
	
	public java.lang.Integer getDiscountId() {
		return this.discountId;
	}
	public void setDiscountName(java.lang.Integer value) {
		this.discountName = value;
	}
	
	public java.lang.Integer getDiscountName() {
		return this.discountName;
	}
	public void setExpiryTime(java.lang.Integer value) {
		this.expiryTime = value;
	}
	
	public java.lang.Integer getExpiryTime() {
		return this.expiryTime;
	}
	public void setExpiryPlay(java.lang.Integer value) {
		this.expiryPlay = value;
	}
	
	public java.lang.Integer getExpiryPlay() {
		return this.expiryPlay;
	}
	public void setState(Integer value) {
		this.state = value;
	}
	
	public Integer getState() {
		return this.state;
	}
	public void setCtime(java.sql.Timestamp value) {
		this.ctime = value;
	}
	
	public java.sql.Timestamp getCtime() {
		return this.ctime;
	}
	public void setUtime(java.sql.Timestamp value) {
		this.utime = value;
	}
	
	public java.sql.Timestamp getUtime() {
		return this.utime;
	}

}

