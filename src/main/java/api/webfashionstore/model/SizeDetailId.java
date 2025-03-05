package api.webfashionstore.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SizeDetailId implements Serializable {

    @Column(name = "size_id", nullable = false)
    private int sizeId;

    @Column(name = "product_id", nullable = false)
    private int productId;
}
