package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Store;
import crimson.store.backend.repo.CategoryRepo;
import crimson.store.backend.repo.StoreRepo;
import crimson.store.backend.request.CategoryRequest;
import crimson.store.backend.response.CategoryResponse;
import crimson.store.backend.response.ProductDTO;
import crimson.store.backend.response.ProductsByCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    StoreRepo storeRepo;

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getName());
        category.setIdentifier(categoryRequest.getIdentifier());
        category.setTopCategory(categoryRequest.isTopCategory());
//        Optional<Store> store = storeRepo.findById(categoryRequest.getStoreId());
//        category.setStore(store.get());
        Category addedCategory = categoryRepo.saveAndFlush(category);
        return ConvertedToCategoryDto(addedCategory);
    }

    private CategoryResponse ConvertedToCategoryDto(Category categoryRequest) {
        CategoryResponse category = new CategoryResponse();
        category.setName(categoryRequest.getCategoryName());
        category.setIdentifier(categoryRequest.getIdentifier());
        category.setTopCategory(categoryRequest.isTopCategory());
      //  category.setStore(categoryRequest.getStore().getId());
        return category;
    }

    public List<CategoryResponse> getCategory() {
        List<Category> categories = categoryRepo.findAll();
        List<CategoryResponse> categoryResponses = categories.stream().map(category -> {
            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setCategoryId(category.getId());
            categoryResponse.setName(category.getCategoryName());
            categoryResponse.setIdentifier(category.getIdentifier());
         return categoryResponse;
        }).collect(Collectors.toList());
        return categoryResponses;
    }
}
