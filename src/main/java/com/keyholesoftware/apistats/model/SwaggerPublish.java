package com.keyholesoftware.apistats.model;

public class SwaggerPublish {

	private String url;
	private Long uid;

	public SwaggerPublish(String url, Long uid) {
		super();
		this.url = url;
		this.uid = uid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}
}
