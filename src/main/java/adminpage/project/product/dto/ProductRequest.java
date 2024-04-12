package adminpage.project.product.dto;

import adminpage.project.product.entity.Category;
import adminpage.project.product.entity.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class ProductRequest {
    @NotBlank(message = "모델명 입력해주세요")
    private String name;

    @NotBlank(message = "코드 입력해주세요" )
    private String code;

    @NotNull(message = "카테고리 선택해주세요")
    private Category category;

    @NotBlank(message = "제조사 입력해주세요")
    private String company;

    @NotBlank(message = "모델명 입력해주세요")
    private int quantity;

    @NotBlank(message = "가격 입력해주세요")
    private int price;

    private boolean open;

    public Product productRequestconvertProduct(ProductRequest productRequest){
        Product product= Product.builder().name(name)
                .code(code)
                .category(category)
                .company(company)
                .quantity(quantity)
                .price(price)
                .open(open).build();
        return product;
    }

    public static ProductRequest productConvertProductRequest(Product product){
        ProductRequest productRequest= new ProductRequest();
        productRequest.setName(product.getName());
        productRequest.setCode(product.getCode());
        productRequest.setCategory(product.getCategory());
        productRequest.setCompany(product.getCompany());
        productRequest.setQuantity(product.getQuantity());
        productRequest.setPrice(product.getPrice());
        productRequest.setOpen(productRequest.isOpen());
        return productRequest;
    }
}
