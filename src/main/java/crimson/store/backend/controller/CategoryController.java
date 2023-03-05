package crimson.store.backend.controller;

import crimson.store.backend.request.CategoryRequest;
import crimson.store.backend.response.CategoryResponse;
import crimson.store.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category/api/v1")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    //http://localhost:8001/category/api/v1/create
    //http://localhost:8001/category/api/v1/all
    @PostMapping("/create")
    @CrossOrigin({"http://localhost:5173/"})
    public ResponseEntity addCategory(@RequestBody CategoryRequest categoryRequest) {
        CategoryResponse categoryResponse = categoryService.addCategory(categoryRequest);
        return new ResponseEntity(categoryResponse, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    @CrossOrigin({"http://localhost:5173/"})
    public ResponseEntity getCategory(){
        List<CategoryResponse> categoryResponse = categoryService.getCategory();
        return new ResponseEntity(categoryResponse, HttpStatus.OK);
    }

}
