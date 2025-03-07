package api.webfashionstore.repository;

import api.webfashionstore.model.Product;
import api.webfashionstore.model.Size;
import api.webfashionstore.model.SizeDetail;
import api.webfashionstore.model.SizeDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SizeDetailRepository extends JpaRepository<SizeDetail, SizeDetailId> {

    boolean existsBySizeAndProduct(Size size, Product product);

    List<SizeDetail> findAllByOrderByProductProductId();

}
