package com.hatim.basics.springboot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages= "com.hatim.basics.springboot")
public class BasicsSpringBootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BasicsSpringBootApplication.class, args);
	}
	
	
}
