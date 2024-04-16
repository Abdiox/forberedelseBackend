package forberedelse.exercise.forberedelsebackend.delivery;

import forberedelse.exercise.forberedelsebackend.productorder.ProductOrder;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "delivery")
    private List<ProductOrder> productOrders = new ArrayList<>();


    public int getTotalWeightInKg() {
        int totalWeight = 0;
        for (ProductOrder productOrder : productOrders) {
            totalWeight += productOrder.getWeightInGrams();
        }

        return totalWeight / 1000;

    }
}

