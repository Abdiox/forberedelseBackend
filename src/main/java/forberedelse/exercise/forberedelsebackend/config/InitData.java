package forberedelse.exercise.forberedelsebackend.config;

import forberedelse.exercise.forberedelsebackend.product.Product;
import forberedelse.exercise.forberedelsebackend.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;  // Tilføj dette

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Creating initial data ...");
        createInitialData();
    }

    private void createInitialData(){
        System.out.println("Creating initial data ...");

        List<Product> products = new ArrayList<>();
        products.add(new Product("Kyllingeunderlår", 20.0,450));
        products.add(new Product("Kyllingefilet", 30.0, 500));
        products.add(new Product("Kyllingelår", 25.0, 400));
        products.add(new Product("Kyllingefars", 15.0, 300));

        // Gem hvert produkt i databasen
        productRepository.saveAll(products);
    }
}
