package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ProductDTO {
    private String productName;
    private String identifier;
    private String type;
    private String imageUrl;
    private String imageThumb;
    private String shortDesc;
    private String longDesc;
    private float listPrice;
    private float offerPrice;

}
