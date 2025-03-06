package fpt.assignment.asm_ts00471_sof3022.HomeController;


import fpt.assignment.asm_ts00471_sof3022.model.Cart;
import fpt.assignment.asm_ts00471_sof3022.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public String viewCart(Model model) {
        int userId = 2; // Cần thay đổi bằng session thực tế
        List<Cart> cartItems = cartService.getCartByUser(userId);
        model.addAttribute("cartItems", cartItems);
        return "layout/cart";
    }

    @PostMapping("/add")
    public String addToCart(@RequestParam int productId, @RequestParam int quantity) {
        int userId = 1; // Cần thay đổi bằng session thực tế
        cartService.addToCart(userId, productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String updateCart(@RequestParam int cartId, @RequestParam int quantity) {
        cartService.updateCart(cartId, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String removeCartItem(@PathVariable("id") int cartId) {
        cartService.removeCartItem(cartId);
        return "redirect:/cart";
    }

    @GetMapping("/clear")
    public String clearCart() {
        int userId = 1; // Cần thay đổi bằng session thực tế
        cartService.clearCart(userId);
        return "redirect:/cart";
    }

    @GetMapping("/view-cart")
    public String viewcart() {
        return "layout/view-cart";
    }
}
