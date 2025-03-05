package api.webfashionstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "promotion_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class PromotionDetail implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "promotionId", column = @Column(name = "promotion_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false))
    })
    private PromotionDetailId promotionDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "promotion_id", nullable = false, insertable = false, updatable = false)
    private Promotion promotion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    @Column(name = "rate", nullable = false, length = 3)
    private int rate;
}
