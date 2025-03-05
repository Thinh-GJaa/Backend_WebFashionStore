package api.webfashionstore.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceDetailId implements Serializable {

    @Column(name = "staff_id", nullable = false)
    private int staffId;

    @Column(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;
}
