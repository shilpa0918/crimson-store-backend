package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class AddressResponse {

    private String firstName;
    private String lastName;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String addressLine1;
    private String addressLine2;
    private Integer userId;

}
