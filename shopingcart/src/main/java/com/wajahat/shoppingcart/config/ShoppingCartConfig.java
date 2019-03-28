package com.wajahat.shoppingcart.config;

import com.wajahat.shoppingcart.service.CardPaymentService;
import com.wajahat.shoppingcart.service.CashPaymentService;
import com.wajahat.shoppingcart.service.PaymentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShoppingCartConfig {

    @Bean
    PaymentService paymentService(CardPaymentService cardPaymentService,
                                  CashPaymentService cashPaymentService) {
        return cashPaymentService;
    }
}
