package api.webfashionstore.repository;

import api.webfashionstore.model.ReceiptDetail;
import api.webfashionstore.model.ReceiptDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptDetailRepository extends JpaRepository<ReceiptDetail, ReceiptDetailId> {

}
