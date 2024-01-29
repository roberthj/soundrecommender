package com.roberthj.soundrecommender.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "com.roberthj.soundrecommender")
@EntityScan(basePackages = "com.roberthj.soundrecommender")
@EnableJpaRepositories(basePackages = "com.roberthj.soundrecommender.repository")
public class DataConfig {}
