/**
 * 
 */
package com.rahul.learn.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.rahul.learn.utils.Constants;

import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:16:30 pm
 */
@Data
@Component
@ConfigurationProperties(prefix=Constants.BEAN_FLAG)
public class MQBeanConfig {
	
	private boolean amq;
	
	private boolean txnAmq;
	
	private boolean wmq;
	

}
