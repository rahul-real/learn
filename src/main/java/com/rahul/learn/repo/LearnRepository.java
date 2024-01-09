package com.rahul.learn.repo;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface LearnRepository {

	void insertvalues(List<Integer> sortedArray);

}
