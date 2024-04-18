package forberedelse.exercise.forberedelsebackend.product;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //http://localhost:8080/product/id/2
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

    //http://localhost:8080/product/name/Kyllingefilet
    @GetMapping("/name/{name}")
    public Optional<Product> getProductByName(@PathVariable String name) {
        return productService.getProductByName(name);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public Product editProduct(@RequestBody Product product, @PathVariable int id) {
        return productService.editProduct(product, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

}
