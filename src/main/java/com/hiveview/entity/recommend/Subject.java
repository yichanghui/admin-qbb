package com.hiveview.entity.recommend;

import java.sql.Timestamp;

public class Subject{
	
	//columns START
	private Long subjectId;
	private Integer seq;
	private String subjectName;
	private String subjectPic;
	private String subjectDesc;
	private String subjectBgImg;
	private Timestamp createdTime;
	private Timestamp updatedTime;
	private Long isEffective;
	private String imgSize;
	//columns END
	public Long getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	public Integer getSeq() {
		return seq;
	}
	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectPic() {
		return subjectPic;
	}
	public void setSubjectPic(String subjectPic) {
		this.subjectPic = subjectPic;
	}
	public String getSubjectDesc() {
		return subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public String getSubjectBgImg() {
		return subjectBgImg;
	}
	public void setSubjectBgImg(String subjectBgImg) {
		this.subjectBgImg = subjectBgImg;
	}
	public Timestamp getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}
	public Timestamp getUpdatedTime() {
		return updatedTime;
	}
	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	public Long getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Long isEffective) {
		this.isEffective = isEffective;
	}
	public String getImgSize() {
		return imgSize;
	}
	public void setImgSize(String imgSize) {
		this.imgSize = imgSize;
	}
	
}

