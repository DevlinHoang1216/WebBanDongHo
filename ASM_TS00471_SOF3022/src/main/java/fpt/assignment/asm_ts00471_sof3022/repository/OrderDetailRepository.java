package fpt.assignment.asm_ts00471_sof3022.repository;

import fpt.assignment.asm_ts00471_sof3022.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
    List<OrderDetail> findByOrder_OrderId(int orderId);
}
