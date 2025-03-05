package api.webfashionstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class OrderDetail implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "orderId", column = @Column(name = "order_id", nullable = false)),
            @AttributeOverride(name = "sizeId", column = @Column(name = "size_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false))
    })
    private OrderDetailId orderDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false),
            @JoinColumn(name = "size_id", referencedColumnName = "size_id", insertable = false, updatable = false)
    })
    private SizeDetail sizeDetail;

    @Column(name = "quantity", nullable = false, length = 4)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, insertable = false, updatable = false)
    private Order order;

    @Column(name = "rating_score", nullable = false, columnDefinition = "INT DEFAULT 0", length = 1)
    private int ratingScore;

    @Column(name = "price", nullable = false, columnDefinition = "DOUBLE DEFAULT 0")
    private float price;

}
