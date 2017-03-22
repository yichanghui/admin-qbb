package com.hiveview.entity.video.tag;


public class ClassSecond extends ClassSecondKey {

	private String secondclassName;
	private Integer sequence;
	private Integer isEffective;
	
	
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public String getSecondclassName() {
		return secondclassName;
	}
	public void setSecondclassName(String secondclassName) {
		this.secondclassName = secondclassName;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

}
