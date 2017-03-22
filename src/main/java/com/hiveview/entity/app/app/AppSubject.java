package com.hiveview.entity.app.app;

import java.sql.Timestamp;

import com.hiveview.entity.bo.AjaxPage;

public class AppSubject extends AjaxPage{
	
	//columns START
	private Long subjectId;
	private Integer seq;
	private String subjectName;
	private String subjectPic;
	private String subjectDesc;
	private String subjectBgImg;
	private Timestamp createdTime;
	private String imgSize;
	private Timestamp updatedTime;
	private Long isEffective;
	private Long categoryId;
	//columns END

	public void setSubjectId(Long value) {
		this.subjectId = value;
	}
	
	public Long getSubjectId() {
		return this.subjectId;
	}
	public void setSeq(Integer value) {
		this.seq = value;
	}
	
	public Integer getSeq() {
		return this.seq;
	}
	public void setSubjectName(String value) {
		this.subjectName = value;
	}
	
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setSubjectPic(String value) {
		this.subjectPic = value;
	}
	
	public String getSubjectPic() {
		return this.subjectPic;
	}
	public void setSubjectDesc(String value) {
		this.subjectDesc = value;
	}
	
	public String getSubjectDesc() {
		return this.subjectDesc;
	}
	public void setSubjectBgImg(String value) {
		this.subjectBgImg = value;
	}
	
	public String getSubjectBgImg() {
		return this.subjectBgImg;
	}
	public void setCreatedTime(Timestamp value) {
		this.createdTime = value;
	}
	
	public Timestamp getCreatedTime() {
		return this.createdTime;
	}
	public void setImgSize(String value) {
		this.imgSize = value;
	}
	
	public String getImgSize() {
		return this.imgSize;
	}
	public void setUpdatedTime(Timestamp value) {
		this.updatedTime = value;
	}
	
	public Timestamp getUpdatedTime() {
		return this.updatedTime;
	}
	public void setIsEffective(Long value) {
		this.isEffective = value;
	}
	
	public Long getIsEffective() {
		return this.isEffective;
	}
	public void setCategoryId(Long value) {
		this.categoryId = value;
	}
	
	public Long getCategoryId() {
		return this.categoryId;
	}

}

