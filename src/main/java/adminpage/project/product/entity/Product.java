package adminpage.project.product.entity;

import adminpage.project.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="product_code",nullable = false,unique = true)
    private String code;

    @Column(name="category",nullable = false)
    private Category category;

    @Column(name="company",nullable = false)
    private String company;

    @Column(name="quantity", nullable = false)
    private int quantity;

    @Column(name="price", nullable = false)
    private int price;

    @Column(name="open", nullable = false)
    private Boolean open;


}
