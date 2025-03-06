package fpt.assignment.asm_ts00471_sof3022.repository;

import fpt.assignment.asm_ts00471_sof3022.model.ProductDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {
    ProductDetail findByProduct_ProductId(int productId);

}
