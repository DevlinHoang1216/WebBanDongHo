package fpt.assignment.asm_ts00471_sof3022.repository;


import fpt.assignment.asm_ts00471_sof3022.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
