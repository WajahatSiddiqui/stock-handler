package com.wajahat.service.stockcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockControllerApplication.class, args);
	}

}
