package com.wajahat.shoppingcart;

import com.wajahat.shoppingcart.domain.Product;
import com.wajahat.shoppingcart.service.PaymentService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    List<Product> productList = new ArrayList<Product>();
    private PaymentService paymentService;

    public Cart(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void add(Product product) {
        productList.add(product);
    }

    public void checkout() {
        paymentService.pay(productList.stream()
                .mapToDouble(product -> product.getQuantity()*product.getPrice()).sum());
    }
}
