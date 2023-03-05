package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CategoryResponse {

    private String identifier;
    private String name;
    private boolean topCategory;
    private Integer store;
    private List<Integer> products;

}
