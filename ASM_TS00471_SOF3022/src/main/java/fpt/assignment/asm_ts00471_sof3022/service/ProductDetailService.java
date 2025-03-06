package fpt.assignment.asm_ts00471_sof3022.service;

import fpt.assignment.asm_ts00471_sof3022.model.ProductDetail;
import fpt.assignment.asm_ts00471_sof3022.repository.ProductDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailService {
    @Autowired
    private ProductDetailRepository productDetailRepository;

    public ProductDetail getProductDetailByProductId(int productId) {
        return productDetailRepository.findByProduct_ProductId(productId);
    }
}
