package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.model.ProductDetail;
import fpt.assignment.asm_ts00471_sof3022.service.CategoryService;
import fpt.assignment.asm_ts00471_sof3022.service.ProductDetailService;
import fpt.assignment.asm_ts00471_sof3022.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {

@Autowired
private ProductDetailService productDetailService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @GetMapping("/product/list")
    public String listProducts(@ModelAttribute("product") Product product,Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "layout/product/product-list";
    }



    @GetMapping("/product/list-by-category/{id}")
    public String productListByCategory(@PathVariable int id, Model model) {

        return "layout/product/product-detail";
    }

    @GetMapping("/product/detail/{id}")
    public String productDetail(@PathVariable int id, Model model) {
        Product product = productService.getProductById(id);
        ProductDetail productDetail = productDetailService.getProductDetailByProductId(id);
        model.addAttribute("product", product);
        model.addAttribute("productDetail", productDetail);
        return "layout/product/product-detail";

    }
}
