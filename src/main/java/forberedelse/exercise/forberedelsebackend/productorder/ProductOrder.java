package forberedelse.exercise.forberedelsebackend.productorder;

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
   // private Product product;
    private int quantity;
}
