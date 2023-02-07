package com.rohim.springboot2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.rohim.springboot2")
@MapperScan("com.rohim.springboot2")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
