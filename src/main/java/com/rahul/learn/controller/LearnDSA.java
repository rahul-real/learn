package com.rahul.learn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rahul.learn.dto.DSANumber;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:00 pm
 */
@RestController
@Slf4j
public class LearnDSA {
	
	@PostMapping("/findPair")
	public Mono<?> findPair(@RequestBody DSANumber numbers){
		log.info("Inside findPair recieved request {}",numbers);
		List<Integer> list = new ArrayList<>();
		list = numbers.getNumbers().stream().sorted().collect(Collectors.toList());
		log.info("numbers {}",numbers.getNumbers());
		log.info("list {}",list);
		int left = 0;
		int right = list.size() - 1;
		while(left < right) {
			int currentSum = list.get(left) + list.get(right);
			if(currentSum == numbers.getTarget()) {
				log.info("Found pair [{},{}]",list.get(left),list.get(right));
				return Mono.just(Arrays.asList(list.get(left),list.get(right)));
			}else if (currentSum < numbers.getTarget()) {
                // Move left pointer to increase the sum
                left++;
            } else {
                // Move right pointer to decrease the sum
                right--;
            }
		}
		list.clear(); 
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Your error message");
	}
	
	@PostMapping("/subArrays")
	public ResponseEntity<?> subarrays(@RequestBody DSANumber numbers){
		List<Integer> list = new LinkedList<>();
		list = numbers.getNumbers().stream().sorted().collect(Collectors.toList());
		int left = 0;
		int right= list.size() -1;
//		while(left<right) {
//			if(list.get(left)< numbers.getTarget() < list.get(right)) {
//				
//			}
//		}
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	

}
