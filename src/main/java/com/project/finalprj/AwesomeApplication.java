package com.project.finalprj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class AwesomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeApplication.class, args);
	}

}
