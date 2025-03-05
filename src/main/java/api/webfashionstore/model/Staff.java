package api.webfashionstore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "staff")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicUpdate
@DynamicInsert
public class Staff implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "staff_id")
    private int staffId;

    @Column(name = "staff_full_name", nullable = false, length = 70)
    private String staffFullName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "gender", nullable = false, length = 1)
    private int gender;

    @Column(name = "create_date", nullable = false)
    private LocalDateTime createDate;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image image;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    private Set<Order> orders = new HashSet<>();

    @PrePersist
    protected void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
