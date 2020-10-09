package com.example.sample.java8;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class Application {

	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		SpringApplication springApplication = new SpringApplication(Application.class);
		springApplication.setWebApplicationType(WebApplicationType.NONE);

		springApplication.run(args);
		log.info("spring application started!");
	}

}
