package com.rahul.learn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Data
@Configuration
@ConfigurationProperties(prefix = "queue")
public class Queues {
	
	private String jsonReader;
	
	private String fixedLengthReader;

}
