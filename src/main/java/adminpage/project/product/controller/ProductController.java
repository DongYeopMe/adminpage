package adminpage.project.product.controller;

import adminpage.project.global.BusinessException;
import adminpage.project.global.ResultResponse;
import adminpage.project.product.dto.ProductRequest;
import adminpage.project.product.entity.Category;
import adminpage.project.product.entity.Product;
import adminpage.project.product.repository.ProductRepository;
import adminpage.project.product.service.ProductService;
import lombok.RequiredArgsConstructor;
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
public class ProductController {
    final ProductService productService;
    final ProductRepository productRepository;
    @GetMapping("/add")
    public String addForm(Model model){
        model.addAttribute("product",new Product());
        return "product/addForm";
    }
    @PostMapping("/add")
    public String addProduct(@Validated @ModelAttribute("productAddRequest") ProductRequest productRequest, RedirectAttributes redirectAttributes){
        productService.saveProduct(productRequest);
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{productId}")
    public String editForm(@PathVariable Long productId, Model model) {
        Optional<Product> product = productRepository.findById(productId);
        Product product1 = product.get();
        model.addAttribute("product", product1);
        return "product/editForm";
    }
    @PatchMapping("/{productId}/edit")
    public String edit(@PathVariable Long productId, @ModelAttribute ProductRequest productRequest) {
        productService.updateProduct(productId,productRequest);
        return "redirect:/form/product/{productId}";
    }
    @GetMapping("/getOne/{productId}")
    public String product(Model model,@PathVariable Long productId) {
        ProductRequest productResponse = productService.getProduct(productId);
        model.addAttribute("productResponse", productResponse);
        return "form/product";
    }
    @GetMapping("/getList")
    public String products(Model model) {
        List<Product> products = productService.getProducts();
        model.addAttribute("products", products);
        return "form/products";
    }
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
    @ModelAttribute("categories")
    public Category[] categories(){
    return Category.values();
}

}
