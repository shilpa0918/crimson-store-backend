package crimson.store.backend.repo;

import crimson.store.backend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Integer> {
    Optional<Category> findByCategoryName(String categoryName);
    Category findByTopCategory(Boolean category);
}
