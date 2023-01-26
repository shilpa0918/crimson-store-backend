package crimson.store.backend.controller;

import crimson.store.backend.request.CategoryRequest;
import crimson.store.backend.response.CategoryResponse;
import crimson.store.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/addCategory")
    public ResponseEntity addCategory(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse categoryResponse = categoryService.addCategory(categoryRequest);
        return new ResponseEntity(categoryResponse, HttpStatus.CREATED);
    }
}
