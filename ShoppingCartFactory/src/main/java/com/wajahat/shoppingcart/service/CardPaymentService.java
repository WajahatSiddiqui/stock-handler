package com.wajahat.shoppingcart.service;

public class CardPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println(amount + " Paid by card");
    }
}
