package com.hubo.apollo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApolloConfigApp {
	public static void main(String[] args) {
		System.setProperty("env", "fat");
		SpringApplication.run(ApolloConfigApp.class, args);
	}
}
