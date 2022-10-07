package com.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DigitalBooksApplication {
	public static void main(String[] args) {
		SpringApplication.run(DigitalBooksApplication.class, args);
	}

}
