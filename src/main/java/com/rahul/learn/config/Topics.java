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
   @since  09-Jan-2024 2024 2:26:43 pm
 */
@Data
@Component
@ConfigurationProperties(prefix = Constants.TOPIC_NAME)
public class Topics {
	
	private String readTopic;

}
