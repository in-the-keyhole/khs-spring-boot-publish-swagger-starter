package com.keyholesoftware.publish.swagger;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("swagger.publish")
public class PublishSwaggerProperties {

	/**
	 * The Swagger API URL
	 */
	private String swaggerUrl;

	/**
	 * The publish URL (currently assumes a POST).
	 */
	private String publishUrl;

	/**
	 * A security token for the publishUrl (optional).
	 */
	private String securityToken;

	public String getSwaggerUrl() {
		return swaggerUrl;
	}

	public void setSwaggerUrl(String swaggerUrl) {
		this.swaggerUrl = swaggerUrl;
	}

	public String getSecurityToken() {
		return securityToken;
	}

	public void setSecurityToken(String securityToken) {
		this.securityToken = securityToken;
	}

	public String getPublishUrl() {
		return publishUrl;
	}

	public void setPublishUrl(String publishUrl) {
		this.publishUrl = publishUrl;
	}
}
