package adminpage.project.product.dto;

import adminpage.project.product.entity.Category;
import adminpage.project.product.entity.Product;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class ProductResponse {
    private Long id;

    private String name;

    private String code;

    private Category category;

    private int price;

    private boolean open;
    public static ProductResponse productConvertProductResponse(Product product){
        ProductResponse productResponse= new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setName(product.getName());
        productResponse.setCode(product.getCode());
        productResponse.setCategory(product.getCategory());
        productResponse.setPrice(product.getPrice());
        productResponse.setOpen(product.getOpen());
        return productResponse;
    }
}
