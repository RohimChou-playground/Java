package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import repository.StudentRepository;
import service.StudentService;

// if want to scan specific package, use @ComponentScan("your.package.name")
@Configuration
@ComponentScan(basePackages = "service;repository")
public class AppConfig {
	
}
