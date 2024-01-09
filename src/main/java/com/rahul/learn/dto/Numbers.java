package com.rahul.learn.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Numbers {
	
	//@NotBlank(message = "numbers should not be blank")
	@NotNull(message = "numbers should not be null")
	private List<Integer> numbers;
	
	@Size(min = 2)
	private String name;

}
