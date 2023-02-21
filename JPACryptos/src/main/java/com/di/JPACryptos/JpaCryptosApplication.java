package com.di.JPACryptos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class JpaCryptosApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCryptosApplication.class, args);
	}

}
