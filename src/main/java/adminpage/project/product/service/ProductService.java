package adminpage.project.product.service;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ErrorCode;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductRequest;
import adminpage.project.product.entity.Product;
import adminpage.project.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static adminpage.project.product.dto.ProductRequest.productConvertProductRequest;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;
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
        Product findproduct = productRepository.findById(productId).get();
        findproduct = productRequest.productRequestconvertProduct(productRequest);
    }

    @Transactional
    public void deleteProduct(Long id){
        Product product= productRepository.findById(id).orElseThrow(
                ()-> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        productRepository.delete(product);
    }
    public ProductRequest getProduct(Long id){
        Product product= productRepository.findById(id).orElseThrow(
                ()-> new BusinessException(ErrorCode.PRODUCT_NOT_FOUND));
        return productConvertProductRequest(product);
    }
    public List<Product> getProducts(){
        return productRepository.findAll();
    }

}
