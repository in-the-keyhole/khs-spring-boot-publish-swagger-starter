# khs-spring-boot-publish-swagger-starter
A Spring Boot starter for publishing swagger API documentation on startup.

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

Add configuration in application.yml:

	swagger:
	  publish:
	    publish-url: http://someHost:somePort/somePublishUri  // Where to publish the Swagger API
	    security-token: someToken                             // An optional security token the publish-url is expecting
	    swagger-url: http://someHost:somePort/someSwaggerUri  // API where swagger API is being served
