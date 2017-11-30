package com.coin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinApplication {

	private static  final Logger logger = LoggerFactory.getLogger(CoinApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CoinApplication.class, args);
		logger.info("My Spring Boot Application Started");
	}


}
