package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.Category;
import fpt.assignment.asm_ts00471_sof3022.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    //Hiển thị category
    @GetMapping("/category/list")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("category", new Category());
        return "layout/product/category";
    }
    @PostMapping("/category/save")
    public String saveCategory(@ModelAttribute("category") Category category, RedirectAttributes redirectAttributes) {
        categoryService.saveCategory(category);
        redirectAttributes.addFlashAttribute("message", "Ghi dữ liệu thành công.");
        return "redirect:/category/list";
    }
    @GetMapping("/category/edit/{id}")
    public String editCategory(@PathVariable("id") int id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "layout/product/category";
    }
    @GetMapping("/category/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            categoryService.deleteCategory(category.getCategoryId());
        }
        redirectAttributes.addFlashAttribute("message", "Xóa dữ liệu thành công.");
        return "redirect:/category/list";
    }
}