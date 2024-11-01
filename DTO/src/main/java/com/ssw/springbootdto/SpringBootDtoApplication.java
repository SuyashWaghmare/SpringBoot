package com.ssw.springbootdto;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDtoApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootDtoApplication.class, args);
        System.out.println("DTO Application Started");
    }

}
