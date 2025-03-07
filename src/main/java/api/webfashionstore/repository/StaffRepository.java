package api.webfashionstore.repository;

import api.webfashionstore.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {

    int countByAccountStatus(boolean status);
}
