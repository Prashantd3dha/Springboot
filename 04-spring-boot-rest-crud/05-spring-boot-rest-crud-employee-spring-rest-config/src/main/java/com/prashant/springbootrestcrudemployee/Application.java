package com.prashant.springbootrestcrudemployee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/*
	sort data
	url = .......members?sort=firstName,lastName,desc
	 */
}
