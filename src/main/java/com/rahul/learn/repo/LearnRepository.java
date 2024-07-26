package com.rahul.learn.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.rahul.learn.dto.UserInfo;
import com.rahul.learn.dto.UsersData;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:34 pm
 */
@Component
public interface LearnRepository {

	void insertvalues(List<Integer> sortedArray);

	/**
	 * @param username
	 * @return
	 */
	Optional<UserInfo> findByName(String username);

	/**
	 * @param txn
	 * @return
	 */
	UsersData getUserData(String txn);
	

}
