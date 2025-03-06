package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.User;
import fpt.assignment.asm_ts00471_sof3022.repository.UserRepository;
import fpt.assignment.asm_ts00471_sof3022.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {
  @Autowired
  UserService userService;

  @GetMapping("/login")
  public String login(Model model) {
    model.addAttribute("user", new User());
    return "layout/auth/login";
  }



  @PostMapping("/userLogin")
  public String doLogin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
    if (username.isEmpty() || password.isEmpty()) {
      model.addAttribute("error", "Tên đăng nhập và mật khẩu không được để trống.");
      return "layout/auth/login";
    }

    User user = userService.validateUser(username, password);
    if (user != null) {
      session.setAttribute("user", user);
      if (user.getRole() == User.UserRole.Admin) {
        return "redirect:/home";
      } else {
        return "redirect:/login";
      }
    }
    model.addAttribute("error", "Sai tên đăng nhập hoặc mật khẩu.");
    return "layout/auth/login";
  }
}
