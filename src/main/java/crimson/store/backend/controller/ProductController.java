package crimson.store.backend.controller;

import crimson.store.backend.request.ProductRequestOMS;
import crimson.store.backend.response.ProductResponse;
import crimson.store.backend.response.ProductResponseOMS;
import crimson.store.backend.response.ProductsByCategoryDTO;
import crimson.store.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;
//http://localhost:8001/products/api/v1/1/add
    @PostMapping("/{storeId}/add")
    @CrossOrigin({"http://localhost:5173/"})
    public ResponseEntity addProduct(@PathVariable String storeId, @RequestBody ProductRequestOMS productRequest) {
        ProductResponseOMS productResponse = productService.addProduct(productRequest);
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

    //get products for a particular category present in a specific store
    //ex: get a PUMA T-SHIRT from a SHIRTS category in CRIMSON store
    // /productName/category-name/store-name
    @GetMapping("/getProductsByCategoryAndStore/{storeName}/{categoryName}")
        public ResponseEntity getProductsByCategoryAndStore(@PathVariable String storeName,@PathVariable String categoryName ){
        List<ProductResponse> productResponses =  productService.getProductsByCategoryAndStore(storeName,categoryName);

        return new ResponseEntity(productResponses,HttpStatus.OK);
    }
    @GetMapping("/sortProduct/{sortType}")
    public ResponseEntity sortProduct(@PathVariable String sortType){
    List<ProductResponse> productResponses =  productService.sortProduct(sortType);
        return new ResponseEntity(productResponses,HttpStatus.OK);
    }
    @GetMapping("/sortProductUsingStream/{sortType}")
    public ResponseEntity sortProductUsingStream(@PathVariable String sortType){
        List<ProductResponse> productResponses =  productService.sortProductUsingStream(sortType);
        return new ResponseEntity(productResponses,HttpStatus.OK);
    }
}
