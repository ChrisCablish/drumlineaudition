package com.example.drumlineaudition;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DrumlineauditionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DrumlineauditionApplication.class, args);
	}

}
