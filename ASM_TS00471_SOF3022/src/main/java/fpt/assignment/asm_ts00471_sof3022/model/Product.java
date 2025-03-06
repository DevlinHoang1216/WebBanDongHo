package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private double price;

    @Column(name = "stock")
    private int stock;

    @Column(name = "brand")
    private String brand;

    @Column(name = "created_at", updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
    private Date createdAt;


    @Column(name = "updated_at")
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreationTimestamp
    private Date updatedAt;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false) // Liên kết với Category
    private Category category;


}
