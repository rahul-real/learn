/**
 * 
 */
package com.rahul.learn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author rahul
   @since  28-Jan-2024 2024 1:19:15 pm
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersData {
	
	//private int id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	public UsersData(Object...fields) {
		//this.id = Integer.valueOf(String.valueOf(fields[0]));
		this.userName = fields[0] == null ? "": String.valueOf(fields[0]);
		this.password = fields[1] == null ? "": String.valueOf(fields[1]);
		this.email = fields[2] == null ? "": String.valueOf(fields[2]);
		
	}
}
