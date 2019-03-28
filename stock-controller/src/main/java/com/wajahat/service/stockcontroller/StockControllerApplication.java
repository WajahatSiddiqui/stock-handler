package com.wajahat.service.stockcontroller;

import com.wajahat.service.stockcontroller.config.StockControllerConfig;
import com.wajahat.service.stockcontroller.core.scheduler.QuoteScheduler;
import com.wajahat.service.stockcontroller.core.service.QuoteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(StockControllerConfig.class)
public class StockControllerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockControllerApplication.class, args);
	}

	/*@Bean
	CommandLineRunner commandLineRunner(QuoteScheduler quoteScheduler) {
		return args -> {
		    quoteScheduler.saveQuoteDetails();
		};
	}*/
}
