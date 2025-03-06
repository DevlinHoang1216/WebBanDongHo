package fpt.assignment.asm_ts00471_sof3022.repository;

import fpt.assignment.asm_ts00471_sof3022.model.Cart;
import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findByUserId(User user);
    Optional<Cart> findByUserIdAndProduct(User user, Product product);
    void deleteByUserId(User user);
}
