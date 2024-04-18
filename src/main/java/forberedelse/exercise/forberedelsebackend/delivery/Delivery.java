package forberedelse.exercise.forberedelsebackend.delivery;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonManagedReference // Denne side håndterer serialiseringen
    private List<ProductOrder> productOrders = new ArrayList<>();


    // Constructor that accepts productOrders
    public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination, List<ProductOrder> productOrders) {
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
        this.productOrders = productOrders != null ? productOrders : new ArrayList<>();
    }

    // Overloaded constructor without productOrders
    public Delivery(LocalDate deliveryDate, String fromWarehouse, String destination) {
        this(deliveryDate, fromWarehouse, destination, new ArrayList<>()); // Call the primary constructor with an empty list
    }

    public int getTotalWeightInKg() {
        int totalWeight = 0;
        for (ProductOrder productOrder : productOrders) {
            totalWeight += productOrder.getWeightInGrams();
        }

        return totalWeight / 1000;

    }
}

