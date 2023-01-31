package crimson.store.backend.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ProductsByCategoryDTO {

    private Integer productCount;
    private List<ProductDTO> products;

}
