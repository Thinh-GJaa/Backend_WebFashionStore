package api.webfashionstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "supplier")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Supplier implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
	private int supplierId;

	@Column(name = "supplier_name", nullable = false, length = 50)
	private String supplierName;

	@Column(name = "email", nullable = false, length = 50, unique = true)
	private String email;

	@Column(name = "phone_number", nullable = false, length = 13, unique = true)
	private String phoneNumber;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "representative", nullable = false, length = 50)
	private String representative;

	@OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	@JsonIgnore
	private Set<Receipt> receipts = new HashSet<>();
}
