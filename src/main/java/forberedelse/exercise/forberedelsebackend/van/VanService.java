package forberedelse.exercise.forberedelsebackend.van;

import forberedelse.exercise.forberedelsebackend.delivery.Delivery;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VanService {
    private final VanRepository vanRepository;

    public VanService(VanRepository vanRepository) {
        this.vanRepository = vanRepository;
    }

    public List<Van> getAllVans() {
        return vanRepository.findAll();
    }

    public Optional<Van> getVanById(long id) {
        return vanRepository.findById(id);
    }

    public Van getVanOrThrow(long id) {
        return vanRepository.findById(id).orElseThrow(() -> new IllegalStateException("Van not found with id: " + id));
    }

    public Van addVan(Van van) {
        return vanRepository.save(van);
    }

    public Van editVan(Van van, long id) {
        van.setId(id);
        return vanRepository.save(van);
    }

    public void deleteVan(long id) {
        vanRepository.deleteById(id);
    }

    public boolean addDeliveryToVan(Delivery delivery, Van van) {
        // Use getTotalWeightInKg() instead of getWeight()
        if (van.getCombinedWeightOfDeliveries() + delivery.getTotalWeightInKg() < van.getCapacityInKg()) {
            van.getDeliveries().add(delivery);
            vanRepository.save(van);
        } else {
            throw new IllegalStateException("Van is full");
        }
        return false;
    }

}
