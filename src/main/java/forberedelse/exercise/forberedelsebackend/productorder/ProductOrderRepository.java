package forberedelse.exercise.forberedelsebackend.productorder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
