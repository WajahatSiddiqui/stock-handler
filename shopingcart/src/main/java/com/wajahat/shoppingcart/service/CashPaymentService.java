package com.wajahat.shoppingcart.service;

import org.springframework.stereotype.Component;

@Component
public class CashPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println(amount + " Paid by Cash");
    }
}
