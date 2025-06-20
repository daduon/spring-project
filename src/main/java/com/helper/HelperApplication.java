package com.helper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.helper.mapper")
public class HelperApplication {

	public static void main(String[] args) {
		System.err.println("Starting Helper Application...");
		SpringApplication.run(HelperApplication.class, args);
	}

}
