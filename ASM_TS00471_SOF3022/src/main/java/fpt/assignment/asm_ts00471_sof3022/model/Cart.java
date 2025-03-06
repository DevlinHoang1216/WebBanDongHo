package fpt.assignment.asm_ts00471_sof3022.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "cart_id")
        private int cartId;

        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        private User userId;

        @ManyToOne
        @JoinColumn(name = "product_id", nullable = false)
        private Product product;

        @Column(name = "quantity", nullable = false)
        private int quantity;

        @Column(name = "added_at", columnDefinition = "DATETIME")
//        @Temporal(TemporalType.TIMESTAMP)
//        @CreationTimestamp// Viết đúng như trong DB
        private Date addedAt;

        // Getters and Setters
    }

