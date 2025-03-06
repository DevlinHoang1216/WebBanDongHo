package fpt.assignment.asm_ts00471_sof3022.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "category_id") // Viết đúng như trong DB
  private Integer categoryId;

  @Column(name = "category_code") // Viết đúng như trong DB
  private String categoryCode;

  @Column(name = "category_name") // Viết đúng như trong DB
  private String categoryName;

  @Column(name = "created_at")
  private Date createdAt;

  @Column(name = "updated_at")
  private Date updatedAt;

//  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
//  private List<Product> products;
}





