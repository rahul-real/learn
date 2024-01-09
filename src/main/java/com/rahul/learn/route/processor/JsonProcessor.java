package com.rahul.learn.route.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JsonProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("Inside Camel Route");
		
	}

}
