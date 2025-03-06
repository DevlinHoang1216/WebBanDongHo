package fpt.assignment.asm_ts00471_sof3022.HomeController;

import fpt.assignment.asm_ts00471_sof3022.model.Category;
import fpt.assignment.asm_ts00471_sof3022.model.Order;
import fpt.assignment.asm_ts00471_sof3022.model.OrderDetail;
import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.service.OrderDetailService;
import fpt.assignment.asm_ts00471_sof3022.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("/order/checkout")
    public String checkout() {
        return "layout/check-out";
    }

    @GetMapping("/order/list")
    public String orderList(@ModelAttribute("order") Order order, Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("oder", new Order());
        return "layout/oder/order-list";
    }


    @GetMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") int id, Model model) {
        Order order = orderService.getOrderById(id);
        if (order == null) {
            return "redirect:/order/list";
        }

        List<OrderDetail> orderDetails = orderDetailService.getOrderDetailsByOrderId(id);

        model.addAttribute("order", order);
        model.addAttribute("orderDetails", orderDetails);

        return "layout/oder/order-detail";
    }


    @GetMapping("/order/my-product-list")
    public String myProductList() {
        return "layout/product/my-product-list";
    }
}
