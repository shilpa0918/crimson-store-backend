package crimson.store.backend.response;

import crimson.store.backend.request.CategoryRequestOMS;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductResponseOMS {
    private String productName;
    private String identifier;
    private List<String> imageString;
    private int listPrice;
    private int offerPrice;
    private String categoryName;
    private CategoryRequestOMS category;
}
