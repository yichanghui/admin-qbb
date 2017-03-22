package com.hiveview.entity.cache;

import java.sql.Timestamp;

public class CacheUrl{
	
	//columns START
	private Integer id;
	private String cacheUrl;
	private String cacheName;
	private Timestamp createTime;
	private Integer isEffective;
	//columns END
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCacheUrl() {
		return cacheUrl;
	}
	public void setCacheUrl(String cacheUrl) {
		this.cacheUrl = cacheUrl;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getIsEffective() {
		return isEffective;
	}
	public void setIsEffective(Integer isEffective) {
		this.isEffective = isEffective;
	}
	public String getCacheName() {
		return cacheName;
	}
	public void setCacheName(String cacheName) {
		this.cacheName = cacheName;
	}

}

