package forberedelse.exercise.forberedelsebackend.delivery;

import java.time.LocalDate;

public class DeliveryRequestDTO {
    private LocalDate deliveryDate;
    private String fromWarehouse;
    private String destination;

    public DeliveryRequestDTO() {
    }

    public DeliveryRequestDTO(LocalDate deliveryDate, String fromWarehouse, String destination) {
        this.deliveryDate = deliveryDate;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getFromWarehouse() {
        return fromWarehouse;
    }

    public void setFromWarehouse(String fromWarehouse) {
        this.fromWarehouse = fromWarehouse;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }


}
