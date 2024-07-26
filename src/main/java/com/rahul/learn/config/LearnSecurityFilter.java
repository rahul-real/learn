///**
// * 
// */
//package com.rahul.learn.config;
//
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.annotation.WebFilter;
//
///**
// * @author rahul
//   @since  14-Jan-2024 2024 3:12:42 pm
// */
//@Component
//@Order(2)
//@WebFilter(urlPatterns = {"/*"}, filterName = "learnSecurityFilter")
//@ConditionalOnProperty(prefix = "rahul.bean", name = "jwtsecurity", havingValue = "true")
//public class LearnSecurityFilter {
//	
//	private static final String ERROR_HEADER_NOT_FOUND = "Required Authorization not found";
//	private static final String ACTUATOR_HEALTH_URL = "/actuator";
//	
//
//}
//
