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
}
