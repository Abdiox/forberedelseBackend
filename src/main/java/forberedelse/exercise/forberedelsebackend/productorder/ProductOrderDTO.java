package forberedelse.exercise.forberedelsebackend.productorder;

public class ProductOrderDTO {
    private long productId;
    private int quantity;

    public ProductOrderDTO() {
    }

    public ProductOrderDTO(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
