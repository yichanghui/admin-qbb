package com.hiveview.entity.app;

import java.sql.Timestamp;

public class WeatherIcon {
	private Integer id;
	private String name;
	private Timestamp createTime;
	private Timestamp updateTime;
	private String dayIcon;
	private String nightIcon;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getDayIcon() {
		return dayIcon;
	}
	public void setDayIcon(String dayIcon) {
		this.dayIcon = dayIcon;
	}
	public String getNightIcon() {
		return nightIcon;
	}
	public void setNightIcon(String nightIcon) {
		this.nightIcon = nightIcon;
	}
}
