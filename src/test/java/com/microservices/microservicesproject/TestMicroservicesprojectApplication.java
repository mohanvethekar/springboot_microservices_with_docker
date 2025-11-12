package com.microservices.microservicesproject;

import org.springframework.boot.SpringApplication;

public class TestMicroservicesprojectApplication {

	public static void main(String[] args) {
		SpringApplication.from(MicroservicesprojectApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
