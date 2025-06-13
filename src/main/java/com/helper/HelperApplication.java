package com.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class HelperApplication {

	public static void main(String[] args) {
		System.err.println("Starting Helper Application...");
		SpringApplication.run(HelperApplication.class, args);
	}

}
