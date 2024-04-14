package forberedelse.exercise.forberedelsebackend.delivery;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    private DeliveryRepository deliveryRepository;

    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getAllDeliveries(){
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getDeliveryById(long id) {
        return deliveryRepository.findById(id);
    }

    public Delivery addDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery editDelivery(Delivery delivery, long id) {
        delivery.setId(id);
        return deliveryRepository.save(delivery);
    }

    public void deleteDelivery(long id) {
        deliveryRepository.deleteById(id);
    }


}
