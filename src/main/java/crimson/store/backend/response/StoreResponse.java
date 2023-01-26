package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class StoreResponse {
    private String identifier;
    private String language;
    private String storeName;
    private String model;
    private String currency;
    private List<Integer> categoryIds;
}
