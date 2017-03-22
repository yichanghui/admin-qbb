package com.hiveview.entity.video;

import java.io.Serializable;

/**
 * 标签关系
 * 
 */
public class VideoSetClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// `sequence` tinyint(5) NOT NULL DEFAULT '0' COMMENT '顺序',
	private Integer sequence;
	// `firstclass_id` bigint(64) NOT NULL,
	private long firstclassId;
	// `secondclass_id` bigint(64) NOT NULL,
	private long secondclassId;
	// `thirdclass_id` bigint(64) NOT NULL,
	private long thirdclassId;
	// `videoset_id` bigint(64) NOT NULL,
	private long videosetId;
	// `videoset_type` tinyint(1) NOT NULL COMMENT '1、电视剧 2、栏目 3、电影',
	private Integer videosetType;

	private String videosetName;

	private String thirdclassName;

	// PRIMARY KEY (`sequence`,`thirdclass_id`,`videoset_id`)
	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public long getFirstclassId() {
		return firstclassId;
	}

	public void setFirstclassId(long firstclassId) {
		this.firstclassId = firstclassId;
	}

	public long getSecondclassId() {
		return secondclassId;
	}

	public void setSecondclassId(long secondclassId) {
		this.secondclassId = secondclassId;
	}

	public long getThirdclassId() {
		return thirdclassId;
	}

	public void setThirdclassId(long thirdclassId) {
		this.thirdclassId = thirdclassId;
	}

	public long getVideosetId() {
		return videosetId;
	}

	public void setVideosetId(long videosetId) {
		this.videosetId = videosetId;
	}

	public Integer getVideosetType() {
		return videosetType;
	}

	public void setVideosetType(Integer videosetType) {
		this.videosetType = videosetType;
	}

	public String getVideosetName() {
		return videosetName;
	}

	public void setVideosetName(String videosetName) {
		this.videosetName = videosetName;
	}

	public String getThirdclassName() {
		return thirdclassName;
	}

	public void setThirdclassName(String thirdclassName) {
		this.thirdclassName = thirdclassName;
	}

}
