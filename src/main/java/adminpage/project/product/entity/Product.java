package adminpage.project.product.entity;

import adminpage.project.member.entity.Member;
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

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="product_code",nullable = false,unique = true)
    private String code;

    @Column(name="category",nullable = false)
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name="price", nullable = false)
    private int price;

    @Column(name="open", nullable = false)
    private Boolean open;
}
