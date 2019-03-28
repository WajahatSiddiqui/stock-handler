package com.wajahat.service.stockviewer;

import com.wajahat.service.stockviewer.config.StockViewerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(StockViewerConfig.class)
public class StockViewerApplication {
	public static void main(String[] args) {
		SpringApplication.run(StockViewerApplication.class, args);
	}
}
