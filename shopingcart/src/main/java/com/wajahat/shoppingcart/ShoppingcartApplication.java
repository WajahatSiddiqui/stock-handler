package com.wajahat.shoppingcart;

import com.wajahat.shoppingcart.domain.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoppingcartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingcartApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(Cart cart) {
		return runner -> {
			cart.add(new Product("Samsung Galaxy S10", 1, 60000));
			cart.add(new Product("Samsung Galaxy S10 Cover", 1, 600));

			cart.checkout();
		};
	}
}
