package com.acn.bootcamp.simpleshop;

import org.komamitsu.spring.data.sqlite.EnableSqliteRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSqliteRepositories
public class SimpleshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleshopApplication.class, args);
	}

}
