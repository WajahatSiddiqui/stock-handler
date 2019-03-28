package com.wajahat.shoppingcart;

import com.wajahat.shoppingcart.domain.Product;
import com.wajahat.shoppingcart.service.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> productList = new ArrayList<>();
    private PaymentService paymentService;

    public Cart(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void add(Product product) {
        productList.add(product);
    }

    public void checkout() {
        paymentService.pay(productList.stream()
                .mapToDouble(product -> product.getQuantity()*product.getPrice()).sum());
    }
}
