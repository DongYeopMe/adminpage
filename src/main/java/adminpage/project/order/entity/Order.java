package adminpage.project.order.entity;

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
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="quantity", nullable = false)
    private int quantity;

}
