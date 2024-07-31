package com.horizon.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmpBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpBackendApplication.class, args);
		System.out.println("Employee Management System is running!!!!");
	}

}
