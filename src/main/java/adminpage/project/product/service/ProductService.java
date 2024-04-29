package adminpage.project.product.service;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ErrorCode;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductRequest;
import adminpage.project.product.dto.ProductResponse;
import adminpage.project.product.entity.Product;
import adminpage.project.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static adminpage.project.global.ErrorCode.PRODUCT_NOT_FOUND;
import static adminpage.project.product.dto.ProductRequest.productConvertProductRequest;
import static adminpage.project.product.dto.ProductResponse.productConvertProductResponse;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    @Transactional
    public void saveProduct(ProductRequest productRequest){
        if(productRepository.findByCode(productRequest.getCode()).isPresent()){
            System.out.println("이미 있는 제품입니다.");
        }
        Product product= productRequest.productRequestconvertProduct(productRequest);
        productRepository.save(product);
    }
    @Transactional
    public void updateProduct(Long productId,ProductRequest productRequest){
        Product findproduct = productRepository.findById(productId).orElseThrow(() -> new BusinessException(PRODUCT_NOT_FOUND));;
        findproduct.setCategory(productRequest.getCategory());
        findproduct.setName(productRequest.getName());
        findproduct.setCode(productRequest.getCode());
        findproduct.setPrice(productRequest.getPrice());
        findproduct.setOpen(productRequest.isOpen());
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
    public List<ProductListResponse> getProducts(){
        List<ProductListResponse> productListResponseList = new ArrayList<>();
        List<Product> productList= productRepository.findAll();
        int size = productList.size();
            for (int i = 0; i < size; i++) {
                Product product=productList.get(i);
                ProductListResponse response = ProductListResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .code(product.getCode())
                        .category(product.getCategory())
                        .price(product.getPrice())
                        .open(product.getOpen())
                        .build();
                productListResponseList.add(response);
            }
        return productListResponseList;
    }

}
