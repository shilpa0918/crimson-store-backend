package crimson.store.backend.controller;

import crimson.store.backend.request.ProductRequest;
import crimson.store.backend.response.ProductResponse;
import crimson.store.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/addProduct")
    public ResponseEntity addProduct(@RequestBody ProductRequest productRequest){
        ProductResponse productResponse =productService.addProduct(productRequest);
        return new ResponseEntity(productResponse, HttpStatus.CREATED);
    }
}
