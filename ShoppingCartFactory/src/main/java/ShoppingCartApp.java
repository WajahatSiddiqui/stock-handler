import com.wajahat.shoppingcart.PaymentServiceFactory;
import com.wajahat.shoppingcart.service.CardPaymentService;
import com.wajahat.shoppingcart.Cart;
import com.wajahat.shoppingcart.domain.Product;
import com.wajahat.shoppingcart.service.CashPaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoppingCartApp {

    public static void main(String args[]) {
        Cart cart = new Cart(PaymentServiceFactory.paymentService("cash"));
        cart.add(new Product("Samsung Galaxy S10", 1, 60000));
        cart.add(new Product("Samsung Galaxy S10 Cover", 1, 600));

        cart.checkout();
    }
}
