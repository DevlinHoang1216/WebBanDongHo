package fpt.assignment.asm_ts00471_sof3022.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccountController {

    @GetMapping("/account/sign-up")
    public String signUp() {
        return "layout/auth/sign-up";
    }

    @GetMapping("/account/edit-profile")
    public String editProfile() {
        return "layout/auth/edit-profile";
    }

    @GetMapping("/account/forgot-password")
    public String forgotPassword() {
        return "layout/auth/forgot-password";
    }

    @GetMapping("/account/change-password")
    public String changePassword() {
        return "layout/auth/change-password";
    }
}
