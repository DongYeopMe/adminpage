package adminpage.project.product.service;

import adminpage.project.global.BusinessException;
import adminpage.project.product.dto.ProductForm;
import adminpage.project.product.dto.ProductListForm;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductResponse;
import adminpage.project.product.entity.Product;
import adminpage.project.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static adminpage.project.global.ErrorCode.PRODUCT_NOT_FOUND;
import static adminpage.project.product.dto.ProductResponse.productConvertProductResponse;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Transactional
    public void saveProduct(ProductForm productForm){
        if(productRepository.findByCode(productForm.getCode()).isPresent()){
            System.out.println("이미 있는 제품입니다.");
        }
        Product product= productForm.productRequestconvertProduct(productForm);
        productRepository.save(product);
    }
    @Transactional
    public void updateProduct(Long productId, ProductForm productForm){
        Product findproduct = productRepository.findById(productId).orElseThrow(() -> new BusinessException(PRODUCT_NOT_FOUND));
        findproduct.setCategory(productForm.getCategory());
        findproduct.setName(productForm.getName());
        findproduct.setCode(productForm.getCode());
        findproduct.setPrice(productForm.getPrice());
        findproduct.setOpen(productForm.isOpen());
    }
    @Transactional
    public void deleteProduct(Long id){
        Product product= productRepository.findById(id).orElseThrow(
                ()-> new BusinessException(PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }
    public ProductResponse getProduct(Long id){
        Product product= productRepository.findById(id).orElseThrow(
                ()-> new BusinessException(PRODUCT_NOT_FOUND));
        return productConvertProductResponse(product);
    }
    public List<ProductListResponse> getProducts(ProductListForm productListForm){
        List<ProductListResponse> productList= productRepository.findByProductsByCodeOrNameOrCategory(productListForm);
        return productList;
    }

}
