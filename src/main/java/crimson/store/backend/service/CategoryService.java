package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Store;
import crimson.store.backend.repo.CategoryRepo;
import crimson.store.backend.repo.StoreRepo;
import crimson.store.backend.request.CategoryRequest;
import crimson.store.backend.response.CategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    StoreRepo storeRepo;

    public CategoryResponse addCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setIdentifier(categoryRequest.getIdentifier());
        category.setTopCategory(categoryRequest.isTopCategory());
        Optional<Store> store = storeRepo.findById(categoryRequest.getStoreId());
        category.setStore(store.get());
        Category addedCategory = categoryRepo.saveAndFlush(category);
        return ConvertedToCategoryDto(addedCategory);
    }

    private CategoryResponse ConvertedToCategoryDto(Category categoryRequest) {
        CategoryResponse category = new CategoryResponse();
        category.setCategoryName(categoryRequest.getCategoryName());
        category.setIdentifier(categoryRequest.getIdentifier());
        category.setTopCategory(categoryRequest.isTopCategory());
        category.setStore(categoryRequest.getStore().getId());
        return category;
    }
}
