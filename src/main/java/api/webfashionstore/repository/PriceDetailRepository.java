package api.webfashionstore.repository;


import api.webfashionstore.model.PriceDetail;
import api.webfashionstore.model.PriceDetailId;
import api.webfashionstore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceDetailRepository extends JpaRepository<PriceDetail, PriceDetailId> {
    PriceDetail findFirstByProductOrderByPriceDetailIdCreateDateDesc(Product product);

}
