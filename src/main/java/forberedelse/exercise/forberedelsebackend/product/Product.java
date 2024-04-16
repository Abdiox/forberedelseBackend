package forberedelse.exercise.forberedelsebackend.product;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String name;
   private double price;
   private Double weight;

   public Product(String name, double price, int weightInGrams) {
       this.name = name;
       this.price = price;
       this.weight = weight;
   }
}
