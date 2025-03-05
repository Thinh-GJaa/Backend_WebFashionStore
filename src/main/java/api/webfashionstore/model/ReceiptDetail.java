package api.webfashionstore.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;

@Entity
@Table(name = "receipt_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
public class ReceiptDetail implements Serializable {

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "receiptId", column = @Column(name = "receipt_id", nullable = false)),
            @AttributeOverride(name = "sizeId", column = @Column(name = "size_id", nullable = false)),
            @AttributeOverride(name = "productId", column = @Column(name = "product_id", nullable = false))
    })
    private ReceiptDetailId receiptDetailId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "product_id", referencedColumnName = "product_id", insertable = false, updatable = false),
            @JoinColumn(name = "size_id", referencedColumnName = "size_id", insertable = false, updatable = false)
    })
    private SizeDetail sizeDetail;

    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;

    @Column(name = "import_price", nullable = false)
    private float importPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receipt_id", nullable = false, insertable = false, updatable = false)
    private Receipt receipt;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;
}