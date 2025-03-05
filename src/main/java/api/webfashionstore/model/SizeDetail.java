package api.webfashionstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "size_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class SizeDetail {

    @EmbeddedId
    private SizeDetailId sizeDetailId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "size_id", nullable = false, insertable = false, updatable = false)
    private Size size;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false, insertable = false, updatable = false)
    private Product product;

    @Column(name = "quantity", nullable = false, length = 10)
    private int quantity;

    @OneToMany(mappedBy = "sizeDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @OneToMany(mappedBy = "sizeDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private Set<ReceiptDetail> receiptDetails = new HashSet<>();

}
