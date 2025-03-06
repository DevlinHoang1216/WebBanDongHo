package fpt.assignment.asm_ts00471_sof3022.service;


import fpt.assignment.asm_ts00471_sof3022.model.Cart;
import fpt.assignment.asm_ts00471_sof3022.model.Product;
import fpt.assignment.asm_ts00471_sof3022.model.User;
import fpt.assignment.asm_ts00471_sof3022.repository.CartRepository;
import fpt.assignment.asm_ts00471_sof3022.repository.ProductRepository;
import fpt.assignment.asm_ts00471_sof3022.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public void addToCart(int userId, int productId, int quantity) {
        Optional<User> userOpt = userRepository.findById(userId);
        Optional<Product> productOpt = productRepository.findById(productId);

        if (userOpt.isEmpty() || productOpt.isEmpty()) {
            throw new RuntimeException("User hoặc sản phẩm không tồn tại");
        }

        User user = userOpt.get();
        Product product = productOpt.get();

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        Optional<Cart> existingCartOpt = cartRepository.findByUserIdAndProduct(user, product);

        Cart cartItem;
        if (existingCartOpt.isPresent()) {
            cartItem = existingCartOpt.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
        } else {
            cartItem = new Cart();
            cartItem.setUserId(user);
            cartItem.setProduct(product);
            cartItem.setQuantity(quantity);
            cartItem.setAddedAt(new Date());
        }
        cartRepository.save(cartItem);
    }

    public List<Cart> getCartByUser(int userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User không tồn tại");
        }
        return cartRepository.findByUserId(userOpt.get());
    }

    public void updateCart(int cartId, int quantity) {
        Optional<Cart> cartOpt = cartRepository.findById(cartId);
        if (cartOpt.isEmpty()) {
            throw new RuntimeException("Giỏ hàng không tồn tại");
        }
        Cart cartItem = cartOpt.get();
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public void removeCartItem(int cartId) {
        cartRepository.deleteById(cartId);
    }

    public void clearCart(int userId) {
        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User không tồn tại");
        }
        cartRepository.deleteByUserId(userOpt.get());
    }
}