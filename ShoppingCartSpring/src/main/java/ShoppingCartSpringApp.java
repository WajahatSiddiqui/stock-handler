import com.wajahat.shoppingcart.service.CardPaymentService;
import com.wajahat.shoppingcart.Cart;
import com.wajahat.shoppingcart.domain.Product;
import com.wajahat.shoppingcart.service.CashPaymentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ShoppingCartSpringApp {

    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        Cart cart = new Cart((CashPaymentService) context.getBean("cash"));
        cart.add(new Product("Samsung Galaxy S10", 1, 60000));
        cart.add(new Product("Samsung Galaxy S10 Cover", 1, 600));

        cart.checkout();
    }
}
