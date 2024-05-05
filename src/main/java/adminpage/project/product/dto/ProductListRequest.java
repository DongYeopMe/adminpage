package adminpage.project.product.dto;

import adminpage.project.product.entity.Category;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListRequest {
    private Category category;

    private String name;

    private String code;
}
