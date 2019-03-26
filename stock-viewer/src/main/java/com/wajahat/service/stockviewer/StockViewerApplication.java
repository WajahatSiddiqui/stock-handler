package com.wajahat.service.stockviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StockViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockViewerApplication.class, args);
	}

}
