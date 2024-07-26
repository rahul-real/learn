/**
 * 
 */
package com.rahul.learn.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rahul.learn.logtime.annotation.LogExecutionTime;

import reactor.core.publisher.Mono;

/**
 * @author rahul
   @since  28-Jan-2024 2024 11:46:29 am
 */
@RestController
@Validated
@RequestMapping("/collection")
public class CollectionController {
	
	@LogExecutionTime
	@GetMapping("/arraylist")
	public Mono<?> createArray(){
		List<String> string = new ArrayList<String>();
		for(int i=0;i<=10;i++) {
			string.add(i, String.valueOf(i));
		}
		string.add("12");
		StringBuffer buffer = new StringBuffer("");
		buffer.append(string);
		String newString = buffer.toString();
		return Mono.just(newString);
	}
	
}
