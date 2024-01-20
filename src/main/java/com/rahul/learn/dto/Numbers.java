package com.rahul.learn.dto;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:10:22 pm
 */
@Data
public class Numbers {
	
	//@NotBlank(message = "numbers should not be blank")
	@NotNull(message = "numbers should not be null")
	private List<Integer> numbers;
	
	@Size(min = 2)
	private String name;

}
