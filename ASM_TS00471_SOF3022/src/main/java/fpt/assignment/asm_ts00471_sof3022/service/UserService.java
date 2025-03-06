package fpt.assignment.asm_ts00471_sof3022.service;

import fpt.assignment.asm_ts00471_sof3022.model.User;
import fpt.assignment.asm_ts00471_sof3022.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User validateUser(String username,String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
