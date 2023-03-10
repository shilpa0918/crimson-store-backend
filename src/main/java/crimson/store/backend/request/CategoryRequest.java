package crimson.store.backend.request;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryRequest {

    private String identifier;
    private String name;
    private boolean topCategory;
    private Integer storeId;
}
