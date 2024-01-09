package com.rahul.learn.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DSANumber {
	
	@NotNull
	private List<Integer> numbers;
	
	private int target;

}
