package crimson.store.backend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequestOMS {
    private String productName;
    private String identifier;
    private String imageString;
    private String imageThumb;
    private int listPrice;
    private int offerPrice;
    private String categoryName;
    private CategoryRequestOMS category;
}