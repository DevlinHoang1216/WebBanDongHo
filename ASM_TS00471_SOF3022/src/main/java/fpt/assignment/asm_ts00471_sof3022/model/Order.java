package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;


    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_price", nullable = false)
    private double totalPrice;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "created_at", columnDefinition = "DATETIME")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp// Viết đúng như trong DB
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp// Viết đúng như trong DB
    private LocalDateTime updatedAt;

    public enum OrderStatus {
        Pending,
        Processing,
        Shipped,
        Delivered,
        Cancelled
    }

}
