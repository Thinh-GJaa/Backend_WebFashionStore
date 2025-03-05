package api.webfashionstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders") // Đổi tên thành "orders" để tránh từ khóa SQL "order"
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Order implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "create_date", nullable = false, updatable = false, length = 30)
    private LocalDateTime createDate;

    @Column(name = "recipient_name", nullable = false, length = 30)
    private String recipientName;

    @Column(name = "address", nullable = false, length = 200)
    private String address;

    @Column(name = "phone_number", nullable = false, length = 13)
    private String phoneNumber;

    @Column(name = "total_amount", nullable = false)
    private float totalAmount;

    @Column(name = "total_discount_amount", nullable = false)
    private float totalDiscountAmount;

    @Column(name = "status", nullable = false, length = 1)
    private int status;

    @Column(name = "reason")
    private String reason;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staff;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private Set<OrderDetail> orderDetails = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        if (createDate == null) {
            createDate = LocalDateTime.now();
        }
    }
}
