/**
 * 
 */
package com.rahul.learn.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.activemq.ActiveMQComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.jms.JMSException;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:06:33 pm
 */
@Component
public class MessageBeanConfiguration {
	
	@Autowired
	private CamelContext camelContext;
	
	@Autowired
	private QueueConfig queueConfig;
	
	@Autowired
	private MQBeanConfig config;
	
	@PostConstruct
	public void addCamelContext() throws NumberFormatException,JMSException {
		
		if(config.isAmq() || config.isTxnAmq()) {
			PooledConnectionFactory connectionFactory = activeMqConnectionFactory();
			if(config.isAmq()) {
				ActiveMQComponent activeMQComponent = new ActiveMQComponent();
				activeMQComponent.setConnectionFactory(connectionFactory);
				camelContext.addComponent(queueConfig.getAmqComponentName(), activeMQComponent);
				
			}
		}
	}

	/**
	 * @return
	 */
	private PooledConnectionFactory activeMqConnectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(queueConfig.getUsername(),queueConfig.getPassword()
				,queueConfig.getBrokerUrl());
		connectionFactory.setUseAsyncSend(false);
		PooledConnectionFactory pooledConnectionFactory = new PooledConnectionFactory();
		pooledConnectionFactory.setConnectionFactory(connectionFactory);
		pooledConnectionFactory.setMaxConnections(queueConfig.getJmsPoolMaxConnection());
		pooledConnectionFactory.setMaximumActiveSessionPerConnection(queueConfig.getJmsPoolMaxActive());
		return pooledConnectionFactory;
	}

}
