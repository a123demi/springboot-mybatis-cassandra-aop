package com.lm.springboot_mybatis_oracle_cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
class StartupApplication {
	public static void main(String[] args) {

		SpringApplication.run(StartupApplication.class, args);
	}
}
