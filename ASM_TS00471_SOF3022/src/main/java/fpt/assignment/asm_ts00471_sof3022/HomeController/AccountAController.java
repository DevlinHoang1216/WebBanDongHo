package fpt.assignment.asm_ts00471_sof3022.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountAController {

    @GetMapping("/admin/account/index")
    public String accountIndex() {
        return "layout/auth/account";
    }

    @GetMapping("/admin/account/edit/{id}")
    public String editAccount(@PathVariable int id) {
        return "layout/auth/account";
    }

    @GetMapping("/admin/account/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        // Thêm mã xử lý để xóa tài khoản
        return "layout/auth/account";
    }

    @GetMapping("/admin/account/create")
    public String createAccount() {
        return "layout/auth/account";
    }

    @GetMapping("/admin/account/update")
    public String updateAccount() {
        // Thêm mã xử lý để cập nhật tài khoản
        return "layout/auth/account";
    }
}
