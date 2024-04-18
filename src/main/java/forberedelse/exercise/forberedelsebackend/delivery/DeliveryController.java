package forberedelse.exercise.forberedelsebackend.delivery;

import forberedelse.exercise.forberedelsebackend.product.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/delivery")
public class DeliveryController {
    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public List<Delivery> getAllDeliveries() {
        return deliveryService.getAllDeliveries();
    }

    @GetMapping("/{id}")
    public Optional<Delivery> getDeliveryById(@PathVariable int id) {
        return deliveryService.getDeliveryById(id);
    }

    @PostMapping
    public Delivery addDelivery(@RequestBody Delivery delivery) {
        return deliveryService.addDelivery(delivery);
    }


    @PutMapping("/{id}")
    public Delivery editDelivery(@RequestBody Delivery delivery, @PathVariable int id) {
        return deliveryService.editDelivery(delivery, id);
    }

  

    @DeleteMapping("/{id}")
    public void deleteDelivery(@PathVariable int id) {
        deliveryService.deleteDelivery(id);
    }


}
