package com.hiveview.entity.po.huanwang;

public class ContentMedia {
	
	private Integer mediaId;
	private String model;
	private String title;
	private String alias;
	private String director;
	private String starring;
	private String country;
	private String released;
	private String imdb;
	private Integer videosetTotal;
	
	public Integer getMediaId() {
		return mediaId;
	}
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getReleased() {
		return released;
	}
	public void setReleased(String released) {
		this.released = released;
	}
	public String getImdb() {
		return imdb;
	}
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}
	public Integer getVideosetTotal() {
		return videosetTotal;
	}
	public void setVideosetTotal(Integer videosetTotal) {
		this.videosetTotal = videosetTotal;
	}
}
