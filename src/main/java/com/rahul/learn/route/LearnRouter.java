package com.rahul.learn.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rahul.learn.config.Queues;
import com.rahul.learn.config.Topics;
import com.rahul.learn.route.processor.JsonProcessor;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:52 pm
 */
@Component
public class LearnRouter extends RouteBuilder {
	
	@Autowired
	Queues queue;
	
	@Autowired
	Topics topic;
	
	@Autowired
	JsonProcessor jsonProcessor;
	
	@Override
    public void configure() throws Exception {
		
		from(queue.getJsonReader())
		.process(jsonProcessor)
		.to(topic.getReadTopic())
		.end();
		
	}

}
