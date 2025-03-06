package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name = "created_at", columnDefinition = "DATETIME")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp// Viết đúng như trong DB
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp// Viết đúng như trong DB
    private LocalDateTime updatedAt;

    public enum UserRole {
        Admin,
        Customer
    }

}
