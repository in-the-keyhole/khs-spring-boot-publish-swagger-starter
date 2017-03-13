# khs-spring-boot-publish-swagger-starter

A Spring Boot starter for publishing [Swagger API](http://swagger.io) on startup. 

Description
------------
This Spring Boot starter can be used to POST Swagger JSON to a publishing target (url) upon startup of the Spring Boot application.  The body of the request will be the raw Swagger JSON, and a security token can be applied to ensure that only authorized clients have access.

Usage
------------
Add this dependency to your pom.xml:

	<dependency>
		<groupId>com.keyholesoftware</groupId>
		<artifactId>khs-spring-publish-swagger-starter</artifactId>
		<version>1.0.0</version>
	</dependency>	

Annotate your Spring Boot main class:

	@SpringBootApplication
	@PublishSwagger
	public class MySpringBootApp {

		public static void main(String[] args) {
			SpringApplication.run(MySpringBootApp.class, args);
		}
	}

Configurable Properties:

	swagger.publish.publish-url - Where to publish the Swagger API (will be called with a POST verb)
	swagger.publish.security-token: An optional security token -- will be sent as a "token" header
	swagger.publish.swagger-url - The URL that supplies the swagger API, will usually be served from the app itself (see examples below)

Example Configuration(s) (i.e. application.yml):

	swagger:
	  publish:
	    publish-url: http://beta.grokola.com/swagger/publish/1027
	    security-token: 9a019713-XXXX-XXXX-XXXX-74090a0ea9f7
	    swagger-url: http://127.0.0.1:${server.port}/v2/api-docs
	   
	swagger:
	  publish:
	    publish-url: http://beta.grokola.com/swagger/publish/1027
	    security-token: 9a019713-XXXX-XXXX-XXXX-74090a0ea9f7
	    swagger-url: http://127.0.0.1:${server.port}/swagger.json	   
