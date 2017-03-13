package com.keyholesoftware.publish.swagger;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableConfigurationProperties(PublishSwaggerProperties.class)
public class EnablePublishSwaggerConfiguration implements ApplicationListener<ApplicationReadyEvent> {

	private static final Logger LOG = LoggerFactory.getLogger(EnablePublishSwaggerConfiguration.class);

	private RestTemplate restTemplate = new RestTemplate();

	private ObjectMapper objectMapper = new ObjectMapper();

	@Value("${swagger.publish.swagger-url}")
	private String swaggerUrl;

	@Value("${swagger.publish.publish-url}")
	private String publishUrl;

	@Value("${swagger.publish.security-token}")
	private String securityToken;

	@Value("${server.port}")
	private String serverPort;

	@Override
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.set("token", securityToken);
			objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

			String json = restTemplate.getForObject(this.swaggerUrl, String.class);
			HttpEntity<String> requestBody = new HttpEntity<String>(json, headers);
			restTemplate.postForObject(publishUrl, requestBody, String.class);
		} catch (Throwable t) {
			LOG.error("Failed to publish swagger API", t);
		}
	}
}