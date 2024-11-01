package com.ssw;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Dto Project work");
		
		
	}
	@Bean
	public ModelMapper mapper()
	{
		return new ModelMapper();
	}

}
