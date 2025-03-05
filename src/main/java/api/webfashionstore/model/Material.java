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
@Table(name = "material")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Material implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private int materialId;

    @Column(name = "material_name", nullable = false, unique = true, length = 50)
    private String materialName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "material", cascade = CascadeType.ALL)
    @JsonIgnore
    @Builder.Default
    private Set<Product> products = new HashSet<>();
}
