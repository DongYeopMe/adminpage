package adminpage.project.product.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(name="product_name",nullable = false)
    private String name;

    @Column(name="product_code",nullable = false,unique = true)
    private String code;

    @Column(name="product_category",nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="product_price", nullable = false)
    private int price;

    @Column(name="product_open", nullable = false)
    private Boolean open;
}
