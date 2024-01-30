package com.roberthj.soundrecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ={"com.roberthj.soundrecommender.repositories"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//TODO
// Unit test everything
// Testcontainers for Postgres
// Exception handling
// Logging
// One extra endpoint
