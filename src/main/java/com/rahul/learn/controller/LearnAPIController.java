package com.rahul.learn.controller;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rahul.learn.dto.Numbers;
import com.rahul.learn.dto.UserInfo;
import com.rahul.learn.dto.UsersData;
import com.rahul.learn.logtime.annotation.LogExecutionTime;
import com.rahul.learn.service.LearnDSAService;
import com.rahul.learn.utils.Constants;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:09:44 pm
 */
@RestController
@Slf4j
@Validated
@RequestMapping("/rahul")
@CrossOrigin
public class LearnAPIController {
	
	@Autowired
	LearnDSAService dsaService;
	
	@Autowired
	ObjectMapper mapper;
	
	@LogExecutionTime
	@GetMapping("/about")
	public ResponseEntity<?> aboutDetails(HttpServletRequest request) throws Exception{
		String id = request.getHeader(Constants.APPLICATION_TRANSACTION_NUMBER);
		if(id==null) {
			id = UUID.randomUUID().toString();
		}
		String hello = "Hello";
		log.info("TransactionNumber {} Request Recieved from UI ", id);
		return new ResponseEntity<>(mapper.writeValueAsString(hello),HttpStatus.ACCEPTED);
	}
	
	@LogExecutionTime
	@PostMapping(path = "/user/login")
	public ResponseEntity<?> getUserAccess(@RequestBody UserInfo userInfo){
		return new ResponseEntity<>(userInfo,HttpStatus.OK);
		
	}

	@LogExecutionTime
	@PostMapping(path = Constants.BINARY_SEARCH)
	public Mono<?> doBinarySearch(@RequestBody @Validated Numbers numbers){
		log.info("Inside Binary Search Controller Path "+ Constants.BINARY_SEARCH);
		List<Integer> sortedBinary = dsaService.doBinarySearch(numbers);
		log.info("After sorting {}",sortedBinary);
		return Mono.just(sortedBinary);
		
	}
	
	@LogExecutionTime
	@PostMapping(path = Constants.READ_VALUES)
	public Flux<?> readValues(@RequestBody @Validated List<Numbers> numbers,HttpServletRequest request){
		String appTxnNum = request.getHeader(Constants.APPLICATION_TRANSACTION_NUMBER);
		List<Integer> numb = new LinkedList<>();
		numb = Arrays.asList(2,1,3,3,3,3);
		return Flux.fromIterable(numb);
		
	}
	
	@LogExecutionTime
	@GetMapping(path = "/search")
	public String doBinarySearch1(@RequestParam @NotBlank(message = "Name should not be blank") String Name, @RequestParam @NotEmpty String number){
		log.info("Inside Binary Search Controller Path "+ Constants.BINARY_SEARCH);
		return "";
		
	}
	
	@LogExecutionTime
	@GetMapping("/getAllUsers")
	public ResponseEntity<UsersData> getUserData(HttpServletRequest request){
		String txn = request.getHeader(Constants.APPLICATION_TRANSACTION_NUMBER);
		UsersData usersData = dsaService.getUserData(txn);
		return ResponseEntity.ok(usersData);
	}
	
	
}
