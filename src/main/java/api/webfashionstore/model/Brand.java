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
@Table(name = "brand")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert // Tối ưu insert, chỉ insert cột có giá trị để tận dụng default trong MySQL
@DynamicUpdate
public class Brand implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id")
	private int brandId;

	@Column(name = "brand_name", nullable = false, unique = true, length = 50)
	private String brandName;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	@Builder.Default
	private Set<Product> products = new HashSet<>();

}
