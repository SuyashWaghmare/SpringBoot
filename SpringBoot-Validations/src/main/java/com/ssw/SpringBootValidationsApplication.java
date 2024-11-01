package com.ssw;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringBootValidationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootValidationsApplication.class, args);
        System.out.println("Spring Validations Application Started");



    }

}
