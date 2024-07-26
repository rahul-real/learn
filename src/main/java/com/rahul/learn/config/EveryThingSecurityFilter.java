/**
 * 
 */
package com.rahul.learn.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  01-Mar-2024 2024 7:05:42 pm
 */
@Component
@Order(2)
@WebFilter(urlPatterns = {"/"}, filterName = "everyThingSecurityFilter")
@ConditionalOnProperty(prefix = "rahul.bean", name = "jwtsecurity", havingValue = "true")
@Slf4j
public class EveryThingSecurityFilter {
	
	private static final String AUTH_NOT_FOUND = "Required Auth header not found";
	
	@Autowired
	ObjectMapper mapper;
	
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException{
//		chain.doFilter(request, response);
//		
//	}
	
}
