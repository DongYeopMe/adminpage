package adminpage.project.product.controller;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ResultResponse;
import adminpage.project.product.dto.ProductForm;
import adminpage.project.product.dto.ProductListForm;
import adminpage.project.product.dto.ProductListResponse;
import adminpage.project.product.dto.ProductResponse;
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
        model.addAttribute("productRequest",new ProductForm());
        return "product/addForm";
    }
    //상품 추가
    @PostMapping("/add")
    public String addProduct(@Validated @ModelAttribute("productRequest") ProductForm productForm, RedirectAttributes redirectAttributes){
        productService.saveProduct(productForm);
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
    public String edit(@PathVariable Long productId, @ModelAttribute ProductForm productForm, RedirectAttributes redirectAttributes) {
        productService.updateProduct(productId, productForm);
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
    public String products(Model model ,@ModelAttribute ProductListForm productListForm) {
        List<ProductListResponse> products = productService.getProducts(productListForm);
        model.addAttribute("productList", products);
        model.addAttribute("productListRequest", productListForm);
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
