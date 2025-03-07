package api.webfashionstore.repository;

import api.webfashionstore.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

    Supplier findByEmail(String email);

    Supplier findBySupplierName(String supplierName);

    Supplier findByPhoneNumber(String phoneNumber);

}
