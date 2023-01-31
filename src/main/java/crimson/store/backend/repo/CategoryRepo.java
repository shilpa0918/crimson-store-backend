package crimson.store.backend.repo;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Category findByCategoryName(String categoryName);
    Category findByTopCategory(Boolean category);
}
