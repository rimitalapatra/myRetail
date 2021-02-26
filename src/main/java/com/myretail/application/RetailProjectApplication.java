package com.myretail.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={"com.myretail","com.myretail.repository"})
@EntityScan("com.myretail.model")
@EnableMongoRepositories("com.myretail.repository")
public class RetailProjectApplication  {
	
	public static void main(String[] args) {
		SpringApplication.run(RetailProjectApplication.class, args);
	}

	

}
