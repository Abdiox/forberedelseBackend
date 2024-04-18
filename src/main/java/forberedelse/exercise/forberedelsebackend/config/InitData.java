package forberedelse.exercise.forberedelsebackend.config;

import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import forberedelse.exercise.forberedelsebackend.product.Product;
import forberedelse.exercise.forberedelsebackend.product.ProductRepository;
import forberedelse.exercise.forberedelsebackend.delivery.DeliveryRepository;
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

    private void createInitialData(){
        System.out.println("Creating initial data ...");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Kyllingeunderlår", 20.0, 450));
        products.add(new Product("Kyllingefilet", 30.0, 500));
        products.add(new Product("Kyllingelår", 25.0, 400));
        products.add(new Product("Kyllingefars", 15.0, 300));

        List<Delivery> deliveries = new ArrayList<>();
        LocalDate date = LocalDate.of(2001, 3, 20); // Year, Month, Day
        deliveries.add(new Delivery(date, "Warehouse1", "Rødovre"));

        // Save each product and delivery to the database
        productRepository.saveAll(products);
        deliveryRepository.saveAll(deliveries);
    }
}
