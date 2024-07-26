package com.rahul.learn.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.rahul.learn.dto.DSANumber;

import jakarta.validation.constraints.NotBlank;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;


/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:00 pm
 */
@RestController
@Slf4j
public class LearnDSA {
	
//	@Autowired
//	private JwtService jwtService;
	
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
	
	@GetMapping("/sortBinaryArrayInLinearTime")
	public ResponseEntity<?> sortBinaryArrayInLinearTime(){
		int[] num = { 0, 0, 1, 0, 1, 1, 0, 1, 0, 0 };
//		int countOfZero = 0;
//		for(int i=0;i<num.length;i++) {
//			if(num[i]==0) {
//				countOfZero += 1;
//			}
//		}
//		int newSize = num.length + 1;
//		int[] sortedBinaryArray = new int[num.length];
//		int k = 0;
//		while(countOfZero-- != 0) {
//			sortedBinaryArray[k++] = 0;
//		}
//		while(k<sortedBinaryArray.length) {
//			sortedBinaryArray[k++] = 1;
//		}
//		log.info("{} {}",sortedBinaryArray,countOfZero);
		int pivot =1;
		int j = 0;
		for(int i=0;i<num.length;i++) {
			if(num[i]<pivot) {
				int temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				j++;
			}
		}
		return new ResponseEntity<>(num, HttpStatus.OK);
	}
	
	@GetMapping("/maximumProductPair")
	public ResponseEntity<?> maximumProductPair(){
		//log.info("Inside findPair recieved request {}",numbers);
		int[] num = { -10, -3, 5, 6, -20 };
//		int max_i = -1, max_j = -1;
//		int maxProduct =Integer.MIN_VALUE;
//		for(int i=0;i<num.length-1;i++) {
//			for(int j=i+1;j<num.length;j++) {
//				
//				if(maxProduct<num[i] * num[j]) {
//					maxProduct = num[i] * num[j];
//					max_i = i;
//					max_j = j;
//				}
//			}
//		}
//		System.out.println("Pair is (" + num[max_i] + ", " + num[max_j] + ")");
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				if(num[i] < num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		int n = num.length;
		if(num[0] * num[1] > num[n-1] * num[n-2]) {
			log.info("Pair and sum is [{},{}:{}}",num[0],num[1],num[0]*num[1]);
		}else {
			log.info("Pair and sum is [{},{}:{}}", num[n-1], num[n-2], num[n-2]* num[n-1]);
		}
		return new ResponseEntity<>(num, HttpStatus.OK);
	}
	
	@GetMapping(path = "/getMajorityElement")
	public ResponseEntity<?> getMajorityElement(){
//		int[] num = {1, 3, 1, 1,5,5,5,12,3,4,5,6,7,8,9,5,1,1,1,1};
//		int counter = 0;
//		for(int i=0;i<num.length;i++) {
//			for(int j=i+1;j<num.length;j++) {
//				if(num[i] == num[j]) {
//					counter++;
//				}
//		        if (counter > num.length/2) {
//		            return new ResponseEntity<>(num[i], HttpStatus.OK);
//		        }
//			}
//		}
		List<Integer> num = Arrays.asList(1, 3, 1, 1,5,5,5,12,3,4,5,6,7,8,9,5,1,1,1,1);
//		Map<Integer, Integer> newMap = new HashMap<>();
//		for(Integer i:num) {
//			newMap.put(i, newMap.getOrDefault(i, 0) + 1);
//		}
//		for(Map.Entry<Integer, Integer> map: newMap.entrySet()) {
//			if (map.getValue() > num.size()/2) {
//				return new ResponseEntity<>(map.getKey(), HttpStatus.OK);
//			}
//		}
		 // create an empty `HashMap`
		int[] nums = { 2, 8, 7, 4, 2, 1, 67, 44, 211, 0, 98,13,2,11,33,1};
        Map<Integer, Integer> map = new HashMap<>();
 
        // store each element's frequency in a map
        for (int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
 
        // return the element if its count is more than `n/2`
        for (Map.Entry<Integer, Integer> entry: map.entrySet())
        {
            if (entry.getValue() > nums.length/2) {
                return new ResponseEntity<>(entry.getKey(), HttpStatus.OK); 
            }
        }
		return new ResponseEntity<>(num.size(), HttpStatus.OK);
	}
	
	@PostMapping(path = "/dobinarySearchA")
	public ResponseEntity<?> binarySerach(@RequestBody DSANumber dsaNumber){
		Integer target = dsaNumber.getTarget();
		//List<Integer> nums = dsaNumber.getNumbers();
		int[] nums = {2, 3, 5, 7, 9};
		int size = nums.length;
		int size2 = size/2;
		//int mid = nums[0] + nums[size-1] /2;
//		if(target > mid){
//			for(int i =size2;i<size;i++){
//				if (nums[i]==target) {
//					return new ResponseEntity<>(i, HttpStatus.OK);
//				}
//			}
//		}else {
//			for(int i =0;i<=size2;i++){
//				if (nums[i]==target) {
//					return new ResponseEntity<>(i, HttpStatus.OK);
//				}
//			}
//		}

		return new ResponseEntity<>("Element Not Found",HttpStatus.BAD_REQUEST);
		
	}
	
	@GetMapping("/derivedString")
	public ResponseEntity<?> getDerivedString(@RequestParam("x")@NotBlank String string1,@RequestParam("y") @NotBlank String string2) {
		String x = string1;
		String y = string2;
		if (x.length() != y.length()) {
			return new ResponseEntity<>("String length should be same",HttpStatus.BAD_REQUEST);
		}
		for(int i = 0; i <x.length();i++) {
			x = x.substring(1) + x.charAt(0);
			if(x.compareTo(y) == 0) {
				return new ResponseEntity<>("Given strings can be derived from each other",HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Given strings cannot be derived from each other",HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/rotateMatrix")
	public ResponseEntity<?> rotateMatrix() {
		int[][] mat =  {
	            { 1, 2, 3, 4 },
	            { 5, 6, 7, 8 },
	            { 9, 10, 11, 12 },
	            { 13, 14, 15, 16 }
	        };
		for(int i=0;i<mat.length;i++) {
			for(int j = i+1;j<mat.length;j++) {
				 int temp = mat[i][j];
	                mat[i][j] = mat[j][i];
	                mat[j][i] = temp;
				log.info("{}{}",mat[i], mat[j]);	
			}
		}
		 for (int i = 0; i < mat.length; i++)
	        {
	            for (int j = 0; j < mat.length / 2; j++)
	            {
	                int temp = mat[i][j];
	                mat[i][j] = mat[i][mat.length - j - 1];
	                mat[i][mat.length - j - 1] = temp;
	                log.info("{}{}",mat[i], mat[j]);	
	            }
	        }
        for (var r: mat) {
            System.out.println(Arrays.toString(r));
        }
		return new ResponseEntity<>(mat,HttpStatus.OK);
	}
	
	@GetMapping("/findMaxSubarraySum")
	public ResponseEntity<?> findMaxSubarraySum(@RequestParam int[] nums){
		//int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		int maxElementSoFar = Integer.MIN_VALUE;
		int maxEnding = 0;
		for(int i:nums) {
			maxEnding = maxEnding + i;
			maxEnding = Integer.max(maxEnding, i);
			maxElementSoFar = Integer.max(maxElementSoFar, maxEnding);
		}
		return new ResponseEntity<>(maxElementSoFar,HttpStatus.OK);
	}
	
	
	
	
//	@PostMapping("/authenticate")
//	public String authenticateAndGetToken(@RequestBody AuthRequest authrRequest) {
//		return jwtService.generateToken(authrRequest.getUserName());
//		
//	}
	

}
