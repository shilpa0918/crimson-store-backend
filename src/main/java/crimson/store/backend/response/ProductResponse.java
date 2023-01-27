package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductResponse {
    private String productName;
    private String identifier;
    private String type;
    private String imageUrl;
    private String imageThumb;
    private String shortDesc;
    private String longDesc;
    private float listPrice;
    private float offerPrice;
    private Integer categoryId;

}
