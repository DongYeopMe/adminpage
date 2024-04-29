package adminpage.project.product.dto;

import adminpage.project.product.entity.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductListResponse {

    private Long id;

    private String name;

    private String code;

    private Category category;

    private int price;

    private boolean open;
}
