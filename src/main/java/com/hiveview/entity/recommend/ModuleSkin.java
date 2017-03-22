package com.hiveview.entity.recommend;

public class ModuleSkin{
	
	//columns START
	private java.lang.Integer id;
	private Integer recomType;
	private java.lang.String imgUrlInside;
	private java.lang.String imgUrlOutside;
	private java.sql.Timestamp createTime;
	//columns END

	public void setId(java.lang.Integer value) {
		this.id = value;
	}
	
	public java.lang.Integer getId() {
		return this.id;
	}
	public void setRecomType(Integer value) {
		this.recomType = value;
	}
	
	public Integer getRecomType() {
		return this.recomType;
	}
	public void setImgUrlInside(java.lang.String value) {
		this.imgUrlInside = value;
	}
	
	public java.lang.String getImgUrlInside() {
		return this.imgUrlInside;
	}
	public void setImgUrlOutside(java.lang.String value) {
		this.imgUrlOutside = value;
	}
	
	public java.lang.String getImgUrlOutside() {
		return this.imgUrlOutside;
	}
	public void setCreateTime(java.sql.Timestamp value) {
		this.createTime = value;
	}
	
	public java.sql.Timestamp getCreateTime() {
		return this.createTime;
	}

}

