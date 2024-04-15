package forberedelse.exercise.forberedelsebackend.delivery;

import forberedelse.exercise.forberedelsebackend.productorder.ProductOrder;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate deliveryDate;
    private String fromWarehouse; // TODO: IN FUTURE, MAYBE REPLACE WITH ACTUAL Warehouse entity
    private String destination;


    public void addProductOrder(ProductOrder productOrder) {
        productOrders.add(productOrder);
    }
}

