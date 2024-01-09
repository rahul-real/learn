package com.rahul.learn.repo.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rahul.learn.repo.LearnRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:46 pm
 */
@Component
@Slf4j
public class LearnRepositoryImpl implements LearnRepository {

	@Override
	public void insertvalues(List<Integer> sortedArray) {
		log.info("Inside LearnRepositoryImpl");
		
	}

}
