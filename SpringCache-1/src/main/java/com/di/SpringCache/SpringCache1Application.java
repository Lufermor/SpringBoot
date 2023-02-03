package com.di.SpringCache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringCache1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCache1Application.class, args);
	}

}
