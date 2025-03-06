package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detailId;


    @Column(name = "material", length = 50)
    private String material;

    @Column(name = "color", length = 30)
    private String color;

    @Column(name = "diameter")
    private Double diameter; // Đơn vị: mm

    @Column(name = "water_resistance", length = 50)
    private String waterResistance;

    @Column(name = "movement_type", length = 50)
    private String movementType;

    @Column(name = "power_reserve", length = 50)
    private String powerReserve;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updatedAt;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
}
