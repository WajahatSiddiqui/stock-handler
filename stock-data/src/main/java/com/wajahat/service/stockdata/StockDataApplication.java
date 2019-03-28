package com.wajahat.service.stockdata;

import com.wajahat.service.stockdata.config.StockDataConfig;
import com.wajahat.service.stockdata.core.repository.QuoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(StockDataConfig.class)
public class StockDataApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockDataApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(QuoteRepository quoteRepository) {
		return args -> {
			quoteRepository.findAll().forEach(System.out::println);
		};
	}
}
