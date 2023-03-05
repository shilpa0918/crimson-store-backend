package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductResponse {
    private String productName;
    private String identifier;
    private String type;
    private List<String> imageString;
    private String imageThumb;
    private String shortDesc;
    private String longDesc;
    private float listPrice;
    private float offerPrice;
    private Integer categoryId;

}
