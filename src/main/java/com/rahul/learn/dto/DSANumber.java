package com.rahul.learn.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:14 pm
 */
@Data
public class DSANumber {
	
	@NotNull
	private List<Integer> numbers;
	
	private int target;

}
