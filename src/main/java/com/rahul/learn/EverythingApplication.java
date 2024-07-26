package com.rahul.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:08:12 pm
 */
@EnableRetry
@EnableAsync
@Configuration
@SpringBootApplication(scanBasePackages = "com.rahul.learn.*")
//@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
public class EverythingApplication {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/rahul");
		SpringApplication.run(EverythingApplication.class, args);
	}

}
