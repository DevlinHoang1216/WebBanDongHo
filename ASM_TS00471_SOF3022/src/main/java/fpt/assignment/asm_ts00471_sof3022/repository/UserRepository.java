package fpt.assignment.asm_ts00471_sof3022.repository;

import fpt.assignment.asm_ts00471_sof3022.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
