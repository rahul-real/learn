package com.rahul.learn.repo.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.rahul.learn.repo.LearnRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LearnRepositoryImpl implements LearnRepository {

	@Override
	public void insertvalues(List<Integer> sortedArray) {
		log.info("Inside LearnRepositoryImpl");
		
	}

}
