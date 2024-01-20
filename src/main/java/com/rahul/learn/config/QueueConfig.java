package com.rahul.learn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.rahul.learn.utils.Constants;

import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:08:17 pm
 */
@Data
@Component
@ConfigurationProperties(prefix = Constants.QUEUE_PREFIX)
public class QueueConfig {
	
	private String username;
	
	private String password;
	
	private String brokerUrl;
	
	private String amqComponentName;
	
	private String txnAmqComponentName;
	
	private int jmsPoolMaxConnection;
	
	private int jmsPoolMaxActive;

}
