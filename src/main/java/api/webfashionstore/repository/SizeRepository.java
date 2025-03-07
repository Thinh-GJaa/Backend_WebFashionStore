package api.webfashionstore.repository;

import api.webfashionstore.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends JpaRepository<Size, Integer> {
    Size findBySizeName(String sizeName);
}
