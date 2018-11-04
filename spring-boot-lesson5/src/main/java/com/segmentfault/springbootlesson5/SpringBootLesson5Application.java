package com.segmentfault.springbootlesson5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.segmentfault.springbootlesson5"})
public class SpringBootLesson5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLesson5Application.class, args);
	}
}
