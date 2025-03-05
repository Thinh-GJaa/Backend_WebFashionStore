package api.webfashionstore.model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "brand")
public class Brand implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private int brandId;

    @Column(name = "brand_name", nullable = false, unique = true)
    private String brandName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
    private Set<Product> products = new HashSet<>();

	public Brand() {
		super();
	}

	public Brand(int brandId) {
		this.brandId = brandId;
	}

	public Brand(String brandName, Set<Product> products) {
		this.brandName = brandName;
		this.products = products;
	}

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

    

    
}