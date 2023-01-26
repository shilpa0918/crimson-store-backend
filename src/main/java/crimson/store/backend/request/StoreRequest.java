package crimson.store.backend.request;

import crimson.store.backend.entity.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StoreRequest {
    private String identifier;
    private String language;
    private String storeName;
    private String model;
    private String currency;

    private List<Category> categories;
}
