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
@Table(name = "receipt")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Receipt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "receipt_id")
	private int receiptId;

	@Column(name = "create_date", nullable = false)
	private LocalDateTime createDate;

	@ManyToOne
	@JoinColumn(name = "supplier_id", nullable = false)
	private Supplier supplier;

	@ManyToOne
	@JoinColumn(name = "staff_id", nullable = false)
	private Staff staff;

	@OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@Builder.Default
	@JsonIgnore
	private Set<ReceiptDetail> receiptDetails = new HashSet<>();

	@PrePersist
	protected void onCreate() {
		this.createDate = LocalDateTime.now();
	}

}
