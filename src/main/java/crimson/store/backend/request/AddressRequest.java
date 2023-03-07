package crimson.store.backend.request;

import crimson.store.backend.entity.Users;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.*;

import javax.persistence.*;


@Setter
@Getter
public class AddressRequest {

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
