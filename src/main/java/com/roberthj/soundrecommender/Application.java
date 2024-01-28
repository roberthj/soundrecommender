package com.roberthj.soundrecommender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages ={"com.domain.foo.bar.*"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

//TODO
// Implement
// Small modular loosely coupled pieces
// Unit test everything
// Testcontainers for Postgres
// Exception handling
// Validate input
// Logging
