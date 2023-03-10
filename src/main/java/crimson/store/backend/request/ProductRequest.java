package crimson.store.backend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductRequest {
    private String productName;
    private String identifier;
    private String type;
    private String imageString;
    private String imageThumb;
    private String shortDesc;
    private String longDesc;
    private float listPrice;
    private float offerPrice;

    private int categoryId;

}
