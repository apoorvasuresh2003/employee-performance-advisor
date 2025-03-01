package com.estuate.employee.performance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.estuate.employee.performance")
public class EmployeePerformanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeePerformanceApplication.class, args);
	}

}
