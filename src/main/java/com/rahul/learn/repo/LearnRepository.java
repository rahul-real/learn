package com.rahul.learn.repo;

import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:34 pm
 */
@Component
public interface LearnRepository {

	void insertvalues(List<Integer> sortedArray);

}
