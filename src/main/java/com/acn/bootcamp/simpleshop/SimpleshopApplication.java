package com.acn.bootcamp.simpleshop;

import com.acn.bootcamp.simpleshop.services.DataSeedingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimpleshopApplication {
	@Autowired
	private DataSeedingService dataSeedingService;
	public static void main(String[] args) {
		SpringApplication.run(SimpleshopApplication.class, args);
	}

	@Bean
	InitializingBean seed()
	{
		return () ->{
			dataSeedingService.
		}
	}
}
