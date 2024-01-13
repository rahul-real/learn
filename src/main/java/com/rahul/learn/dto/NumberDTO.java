/**
 * 
 */
package com.rahul.learn.dto;

import java.math.BigInteger;

import lombok.Data;

/**
 * @author rahul
   @since  12-Jan-2024 2024 11:14:35 am
 */
@Data
public class NumberDTO {
	
	private BigInteger num;
	
	private String id;
	
	public NumberDTO(Object ... field) {
		
		this.num = (BigInteger) (field[0]);
		this.id = String.valueOf(field[1]);
		
	}

}
