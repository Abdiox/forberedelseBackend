package forberedelse.exercise.forberedelsebackend.config;

import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import forberedelse.exercise.forberedelsebackend.delivery.DeliveryRepository;
import forberedelse.exercise.forberedelsebackend.product.Product;
import forberedelse.exercise.forberedelsebackend.product.ProductRepository;
import forberedelse.exercise.forberedelsebackend.productorder.ProductOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating initial data ...");
        createInitialData();
    }

    private void createInitialData() {
        System.out.println("Creating initial data ...");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Kyllingeunderlår", 20.0, 450));
        products.add(new Product("Kyllingefilet", 30.0, 500));
        products.add(new Product("Kyllingelår", 25.0, 400));
        products.add(new Product("Kyllingefars", 15.0, 300));

        productRepository.saveAll(products);


        Product product1 = products.get(0);

        LocalDate date = LocalDate.of(2001, 3, 20);
        Delivery delivery = new Delivery(date, "Warehouse1", "Rødovre", new ArrayList<>());

        ProductOrder order1 = new ProductOrder(product1, 3);


        delivery.getProductOrders().add(order1);
        order1.setDelivery(delivery);


        // Gem leverancen
        deliveryRepository.save(delivery);
    }
}
