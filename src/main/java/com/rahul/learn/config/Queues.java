package com.rahul.learn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.rahul.learn.utils.Constants;

import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:09:39 pm
 */
@Data
@Configuration
@ConfigurationProperties(prefix = Constants.QUEUE_NAME)
public class Queues {
	
	private String jsonReader;
	
	private String fixedLengthReader;

}
