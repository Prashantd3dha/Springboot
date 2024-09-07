package com.luv2code.springboot.cruddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	// roles and user implemented
	// implement jdbc for dynamic user and roles details
	//implement bcrypt password {bcrpt}
	// custom table for authentication and authorization
}
