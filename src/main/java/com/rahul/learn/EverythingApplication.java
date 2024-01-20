package com.rahul.learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author rahul
   @since  09-Jan-2024 2024 1:08:12 pm
 */
@SpringBootApplication(scanBasePackages = "com.rahul.learn.*")
public class EverythingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EverythingApplication.class, args);
	}

}
