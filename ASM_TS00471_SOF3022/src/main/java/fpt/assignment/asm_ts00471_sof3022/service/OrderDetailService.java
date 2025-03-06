package fpt.assignment.asm_ts00471_sof3022.service;

import fpt.assignment.asm_ts00471_sof3022.model.OrderDetail;
import fpt.assignment.asm_ts00471_sof3022.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<OrderDetail> getOrderDetailsByOrderId(int orderId) {
        return orderDetailRepository.findByOrder_OrderId(orderId);
    }
    public OrderDetail getOrderDetailById(int id) {
        return orderDetailRepository.findById(id).orElse(null);
    }
}
