package forberedelse.exercise.forberedelsebackend.van;

import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Van {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

private String brand;
private String model;
private int capacityInKg;

@OneToMany
private List<Delivery> deliveries;
}
