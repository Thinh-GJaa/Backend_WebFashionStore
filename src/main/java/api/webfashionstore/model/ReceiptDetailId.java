package api.webfashionstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReceiptDetailId implements Serializable {

    @Column(name = "size_id", nullable = false)
    private int sizeId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "receipt_id", nullable = false)
    private int receiptId;
}
