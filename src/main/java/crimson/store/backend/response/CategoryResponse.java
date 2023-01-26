package crimson.store.backend.response;

import crimson.store.backend.entity.Product;
import crimson.store.backend.entity.Store;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryResponse {

    private String identifier;
    private String categoryName;
    private String topCategory;
    private Store store;
    private List<Product> products;

}
