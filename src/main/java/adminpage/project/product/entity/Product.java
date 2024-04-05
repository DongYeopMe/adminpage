package adminpage.project.product.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="category",nullable = false)
    private Category category;

    @Column(name="quantity", nullable = false)
    private int quantity;



}
