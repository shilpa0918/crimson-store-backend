package crimson.store.backend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StoreRequest {
    private String identifier;
    private String language;
    private String storeName;
    private String model;
    private String currency;
}
