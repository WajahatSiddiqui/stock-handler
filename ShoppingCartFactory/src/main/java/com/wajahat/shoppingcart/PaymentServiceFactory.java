package com.wajahat.shoppingcart;

import com.wajahat.shoppingcart.service.CardPaymentService;
import com.wajahat.shoppingcart.service.CashPaymentService;
import com.wajahat.shoppingcart.service.PaymentService;

public class PaymentServiceFactory {
    public static PaymentService paymentService(String method) {
        switch (method) {
            case "cash":
                return new CashPaymentService();
            case "card":
                return new CardPaymentService();
            default:
                return null;
        }
    }
}
