package api.webfashionstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDetailId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "promotion_id")
    private int promotionId;

    @Column(name = "product_id")
    private int productId;
}
