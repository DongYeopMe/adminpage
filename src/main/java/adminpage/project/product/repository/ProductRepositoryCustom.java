package adminpage.project.product.repository;

import adminpage.project.product.dto.ProductListRequest;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductRequest;
import adminpage.project.product.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {

   List<ProductListResponse> findByProductsByCodeOrNameOrCategory(ProductListRequest productListRequest);
}
