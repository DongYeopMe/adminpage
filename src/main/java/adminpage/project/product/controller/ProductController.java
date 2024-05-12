package adminpage.project.product.controller;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ResultResponse;
import adminpage.project.product.dto.ProductListRequest;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductRequest;
import adminpage.project.product.dto.ProductResponse;
import adminpage.project.product.entity.Category;
import adminpage.project.product.entity.Product;
import adminpage.project.product.repository.ProductRepository;
import adminpage.project.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

import static adminpage.project.global.ErrorCode.PRODUCT_CANT_DELETE;
import static adminpage.project.global.ResultCode.MEMBER_DELETE_SUCCESS;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
@Slf4j
public class ProductController {
    final ProductService productService;
    final ProductRepository productRepository;
    //상품 추가 폼
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("productRequest",new ProductRequest());
        return "product/addForm";
    }
    //상품 추가
    @PostMapping("/add")
    public String addProduct(@Validated @ModelAttribute("productRequest") ProductRequest productRequest, RedirectAttributes redirectAttributes){
        productService.saveProduct(productRequest);
        return "redirect:/products/list";
    }
    // 상품 수정 폼
    @GetMapping("/edit/{productId}")
    public String editForm(@PathVariable Long productId, Model model) {
        ProductResponse productResponse = productService.getProduct(productId);
        model.addAttribute("productResponse", productResponse);
        return "product/editForm";
    }
    //상품 수정
    @PostMapping("/edit/{productId}")
    public String edit(@PathVariable Long productId, @ModelAttribute ProductRequest productRequest, RedirectAttributes redirectAttributes) {
        productService.updateProduct(productId,productRequest);
        return "redirect:/products/list";
    }
    //상품 조회
    @GetMapping("/getOne/{productId}")
    public String product(Model model,@PathVariable Long productId) {
        ProductResponse productResponse = productService.getProduct(productId);
        model.addAttribute("productResponse", productResponse);
        return "product/product";
    }
    // 상품 리스트 조회
    @GetMapping("/list")
    public String products(Model model ,@ModelAttribute ProductListRequest productListRequest) {
        List<ProductListResponse> products = productService.getProducts(productListRequest);
        model.addAttribute("productList", products);
        model.addAttribute("productListRequest",productListRequest);
        return "product/products";
    }
    //상품 삭제
    @DeleteMapping("/{productId}")
    public ResponseEntity<ResultResponse> deleteProduct(@PathVariable Long productId){
        try{
            productService.deleteProduct(productId);
            return ResponseEntity.ok(new ResultResponse(MEMBER_DELETE_SUCCESS,"/products"));
        }
        catch (Exception e){
            throw new BusinessException(PRODUCT_CANT_DELETE);
        }
    }
}
