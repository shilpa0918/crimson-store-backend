package crimson.store.backend.response;

import crimson.store.backend.request.CategoryRequestOMS;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductResponseOMS {
    private int productId;
    private String productName;
    private String identifier;
    private List<String> imageString;
    private List<String> images;
    private int basePrice;
    private int offerPrice;
    private String categoryName;
    private CategoryRequestOMS category;
}
