package fpt.assignment.asm_ts00471_sof3022.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CategoryAController {

    @GetMapping("/admin/category/index")
    public String categoryIndex() {
        return "layout/category";
    }

    @GetMapping("/admin/category/edit/{id}")
    public String editCategory(@PathVariable int id) {
        // Thêm mã xử lý để chỉnh sửa loại hàng
        return "layout/category";
    }

    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        // Thêm mã xử lý để xóa loại hàng
        return "layout/category";
    }

    @GetMapping("/admin/category/create")
    public String createCategory() {

        return "layout/category";
    }

    @GetMapping("/admin/category/update")
    public String updateCategory() {
        // Thêm mã xử lý để cập nhật loại hàng
        return "layout/category";
    }
}
