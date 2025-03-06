package fpt.assignment.asm_ts00471_sof3022.service;

import fpt.assignment.asm_ts00471_sof3022.model.Order;
import fpt.assignment.asm_ts00471_sof3022.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order getOrderById(int id){
        return  orderRepository.findById(id).orElseGet(()->null);
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrder(int id){
        orderRepository.deleteById(id);
    }
}
