package com.rahul.learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.learn.dto.Numbers;
import com.rahul.learn.repo.LearnRepository;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:11:07 pm
 */
@Service
public class LearnDSAService {
	
	@Autowired
	LearnRepository learnRepository;

	public List<Integer> doBinarySearch(Numbers numbers) {
//		List<Integer> sortedArray = new LinkedList<>();
//		for(Integer number:numbers.getNumbers()) {
//			Integer temp = number;
//			if(sortedArray !=null && !sortedArray.isEmpty()) {
//				for(Integer sorted:sortedArray) {
//					if(sorted<number) {
//						sortedArray.add(temp);
//					}else {
//						sortedArray.remove(sorted);
//						sortedArray.add(temp);
//						sortedArray.add(sorted);
//					}
//				}
//			}else {
//				sortedArray.add(number);
//			}
//		}
		 List<Integer> sortedArray = numbers.getNumbers().stream()
	                .sorted()
	                .collect(Collectors.toList());
		 learnRepository.insertvalues(sortedArray);
		return sortedArray.reversed();
		
		
	}

}
