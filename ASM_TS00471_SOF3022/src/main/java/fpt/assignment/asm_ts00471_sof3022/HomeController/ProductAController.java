package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.service.CategoryService;
import fpt.assignment.asm_ts00471_sof3022.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductAController {
    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;
    @GetMapping("/admin/product/index")
    public String productIndex() {
        return "layout/product/product";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String editProduct(@PathVariable("id") int id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("products", product);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "layout/product/product"; // Chỉnh sửa trên form New Product
    }


    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Xóa Thành Công");
        return "redirect:/product/list"; // Load lại danh sách sản phẩm
    }


    @GetMapping("/admin/product/create")
    public String createProduct(@ModelAttribute("products") Product product, Model model) {
        model.addAttribute("categories",(categoryService.getAllCategories()));
        return "layout/product/product";
    }

    @PostMapping("/admin/product/update")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/product/list";
}
}
