package com.rahul.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rahul.learn.config.Queues;
import com.rahul.learn.route.processor.JsonProcessor;

@Component
public class LearnRouter extends RouteBuilder {
	
	@Autowired
	Queues queue;
	
	@Autowired
	JsonProcessor jsonProcessor;
	
	@Override
    public void configure() throws Exception {
		
		from(queue.getJsonReader())
		.process(jsonProcessor)
		.end();
		
	}

}
