package com.ccoimbra.portfoliotechchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableJdbcRepositories
public class PortfolioTechChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioTechChallengeApplication.class, args);
	}

}
