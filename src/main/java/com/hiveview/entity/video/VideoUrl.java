package com.hiveview.entity.video;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 视频播放地址
 *
 */
public class VideoUrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	`video_id` varchar(250) NOT NULL COMMENT 'id',
	private String videoId;
//	  `video_type` tinyint(1) NOT NULL COMMENT '1、电视剧 2、栏目 3、电影 4、新闻',
	private Integer videoType;
//	  `m3u8` text,
	private String m3u8;
//	  `mp4` text,
	private String mp4;
//	  `start_time` varchar(255) DEFAULT NULL COMMENT '开始时间',
	private String startTime;
//	  `end_time` varchar(255) DEFAULT NULL COMMENT '结束时间',
	private String endTime;
//	  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	private Timestamp updateTime;
//	  `is_effective` tinyint(1) NOT NULL DEFAULT '1',
	private Integer isEffective;
//	  `vid` int(11) NOT NULL DEFAULT '0' COMMENT '码流 1:300 2:600 3:800 4:1000 5:720p 6:1080P 7:极速码流',
	private String vid;
//	  PRIMARY KEY (`video_type`,`video_id`,`vid`)
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	public String getM3u8() {
		return m3u8;
	}
	public void setM3u8(String m3u8) {
		this.m3u8 = m3u8;
	}
	public String getMp4() {
		return mp4;
	}
	public void setMp4(String mp4) {
		this.mp4 = mp4;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Timestamp getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
}
