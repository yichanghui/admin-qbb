package com.hiveview.entity.app;

import java.sql.Timestamp;

public class WeatherWallpaper {
	
	private Integer id;
	private Integer weatherIconId;
	private String dayWallpaper;
	private String nightWallpaper;
	private Integer wallpaperState;
	private Timestamp createTime;
	private Timestamp updateTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getWeatherIconId() {
		return weatherIconId;
	}
	public void setWeatherIconId(Integer weatherIconId) {
		this.weatherIconId = weatherIconId;
	}
	public String getDayWallpaper() {
		return dayWallpaper;
	}
	public void setDayWallpaper(String dayWallpaper) {
		this.dayWallpaper = dayWallpaper;
	}
	public String getNightWallpaper() {
		return nightWallpaper;
	}
	public void setNightWallpaper(String nightWallpaper) {
		this.nightWallpaper = nightWallpaper;
	}
	public Integer getWallpaperState() {
		return wallpaperState;
	}
	public void setWallpaperState(Integer wallpaperState) {
		this.wallpaperState = wallpaperState;
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
	
}
