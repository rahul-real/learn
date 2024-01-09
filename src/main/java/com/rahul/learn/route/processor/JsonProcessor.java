package com.rahul.learn.route.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:57 pm
 */
@Component
@Slf4j
public class JsonProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("Inside Camel Route");
		
	}

}
