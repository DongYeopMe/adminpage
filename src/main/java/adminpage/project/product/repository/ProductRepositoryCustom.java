package adminpage.project.product.repository;

import adminpage.project.product.dto.ProductListForm;
import adminpage.project.product.dto.ProductListResponse;

import java.util.List;

public interface ProductRepositoryCustom {

   List<ProductListResponse> findByProductsByCodeOrNameOrCategory(ProductListForm productListForm);
}
