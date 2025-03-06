package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.Order;
import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.service.OrderDetailService;
import fpt.assignment.asm_ts00471_sof3022.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderAController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/admin/order/index")
    public String orderIndex() {
        return "layout/oder/order";
    }

    @GetMapping("/admin/order/edit/{id}")
    public String editOrder(@PathVariable int id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        model.addAttribute("orders", orderService.getAllOrders());
        return "layout/oder/order";
    }

    @GetMapping("/admin/order/delete/{id}")
    public String deleteOrder(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        orderService.deleteOrder(id);
        return "redirect:/order/list";
    }

    @GetMapping("/admin/order/create")
    public String createOrder(@ModelAttribute("order") Order order, Model model) {
        return "layout/oder/order";
    }

    @PostMapping("/admin/order/update")
    public String updateOrder(@ModelAttribute("order") Order order, RedirectAttributes redirectAttributes) {
        orderService.saveOrder(order);
        redirectAttributes.addFlashAttribute("message", "Sửa Thành Công");
        return "redirect:/order/list";
    }
}
