package crimson.store.backend.controller;

import crimson.store.backend.request.ProductRequest;
import crimson.store.backend.response.ProductResponse;
import crimson.store.backend.response.ProductsByCategoryDTO;
import crimson.store.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest) {
        ProductResponse productResponse = productService.addProduct(productRequest);
        return new ResponseEntity(productResponse, HttpStatus.CREATED);
    }

    @GetMapping("/getProductsByCategory/{categoryName}")
    public ResponseEntity getProductsByCategory(@PathVariable String categoryName) {
        ProductsByCategoryDTO productsByCategoryDTO = productService.getProductsByCategory(categoryName);
        return new ResponseEntity(productsByCategoryDTO, HttpStatus.OK);
    }

    @GetMapping("/getTopCategoryProducts/{topCategory}")
    public ResponseEntity getTopCategoryProducts(String topCategory) {
        ProductsByCategoryDTO productsByCategoryDTO = productService.getTopCategoryProducts(Boolean.valueOf(topCategory));
        return new ResponseEntity(productsByCategoryDTO, HttpStatus.OK);
    }
}
