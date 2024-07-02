package adminpage.project.product.dto;

import adminpage.project.product.entity.Category;
import adminpage.project.product.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@Setter
@Builder
@Getter
@NoArgsConstructor
public class ProductForm {
    @NotBlank(message = "모델명 입력해주세요")
    private String name;

    @NotBlank(message = "코드 입력해주세요" )
    private String code;

    @NotNull(message = "카테고리 선택해주세요")
    private Category category;

    @NotNull(message = "가격 입력해주세요")
    private int price;

    private boolean open;

    public Product productRequestconvertProduct(ProductForm productForm){
        Product product= Product.builder().name(name)
                .code(code)
                .category(category)
                .price(price)
                .open(open).build();
        return product;
    }

    public static ProductForm productConvertProductRequest(Product product){
        ProductForm productForm = new ProductForm();
        productForm.setName(product.getName());
        productForm.setCode(product.getCode());
        productForm.setCategory(product.getCategory());
        productForm.setPrice(product.getPrice());
        productForm.setOpen(productForm.isOpen());
        return productForm;
    }
}
