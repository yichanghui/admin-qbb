package com.hiveview.entity.video;

public class VideosetRelated  implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	
	//columns START
	private java.lang.Integer sequence;
	private java.lang.Long videosetId;
	private java.lang.Long relatedContentId;
	private Integer relatedType;
	private Integer videosetType;
	private Integer relatedContentType;
	private String videosetName;
	//columns END

	public VideosetRelated(){
	}

	public VideosetRelated(
		java.lang.Long videosetId,
		java.lang.Long relatedContentId
	){
		this.videosetId = videosetId;
		this.relatedContentId = relatedContentId;
	}

	public void setSequence(java.lang.Integer value) {
		this.sequence = value;
	}
	
	public java.lang.Integer getSequence() {
		return this.sequence;
	}
	public void setVideosetId(java.lang.Long value) {
		this.videosetId = value;
	}
	
	public java.lang.Long getVideosetId() {
		return this.videosetId;
	}
	public void setRelatedContentId(java.lang.Long value) {
		this.relatedContentId = value;
	}
	
	public java.lang.Long getRelatedContentId() {
		return this.relatedContentId;
	}
	public void setRelatedType(Integer value) {
		this.relatedType = value;
	}
	
	public Integer getRelatedType() {
		return this.relatedType;
	}

	public Integer getVideosetType() {
		return videosetType;
	}

	public void setVideosetType(Integer videosetType) {
		this.videosetType = videosetType;
	}

	public Integer getRelatedContentType() {
		return relatedContentType;
	}

	public void setRelatedContentType(Integer relatedContentType) {
		this.relatedContentType = relatedContentType;
	}

	public String getVideosetName() {
		return videosetName;
	}

	public void setVideosetName(String videosetName) {
		this.videosetName = videosetName;
	}

}

