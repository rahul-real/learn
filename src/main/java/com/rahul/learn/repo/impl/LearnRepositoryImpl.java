package com.rahul.learn.repo.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.learn.config.StoredProcedures;
import com.rahul.learn.dto.NumberDTO;
import com.rahul.learn.repo.LearnRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.StoredProcedureQuery;
import lombok.extern.slf4j.Slf4j;

/**
 * @author rahul
 * @since 09-Jan-2024 2024 1:10:46 pm
 */

@Slf4j
@Repository
@Transactional
public class LearnRepositoryImpl implements LearnRepository {
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	@Autowired
	StoredProcedures procedures;

	@SuppressWarnings("unchecked")
	@Override
	@Retryable(maxAttempts = 5, retryFor = Throwable.class, backoff = @Backoff(delay = 5000, multiplier = 2))
	public void insertvalues(List<Integer> sortedArray) {
		log.info("Inside LearnRepositoryImpl");
		EntityManager entityManager =null;
		StoredProcedureQuery storedProcedure =null;
		List<Object> list = null;
		NumberDTO number = null;
		try {
			entityManager = entityManagerFactory.createEntityManager();
			storedProcedure = entityManager.createStoredProcedureQuery(procedures.getMyfirstStroeProc());
			storedProcedure.execute();
			list = storedProcedure.getResultList();
			if(list != null && list.size()>0) {
				number = list.parallelStream().map(NumberDTO::new).collect(Collectors.toList()).get(0);
				log.info("List of numbers in Database {}",number);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			closeResources(entityManager);
		}
	}
	
	private void closeResources(EntityManager entityManager) {
		if(null!=entityManager) {
			entityManager.close();
		}
	}

}
