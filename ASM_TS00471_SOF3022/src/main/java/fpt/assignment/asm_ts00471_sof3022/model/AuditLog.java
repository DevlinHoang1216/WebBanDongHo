package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@ToString
@Entity
@Table(name = "audit_logs")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_id")
    private int logId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User userId;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "action_time", columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime actionTime;

    @Column(name = "ip_address")
    private String ipAddress;

    // Getters and Setters
}
