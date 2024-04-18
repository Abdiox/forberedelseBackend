package forberedelse.exercise.forberedelsebackend.productorder;

import com.fasterxml.jackson.annotation.JsonBackReference;
import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import forberedelse.exercise.forberedelsebackend.product.Product;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Product product;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    @JsonBackReference // Denne side undlader serialisering

    private Delivery delivery;

    public ProductOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getWeightInGrams(){
        return product.getWeight()*quantity;
    }
}
