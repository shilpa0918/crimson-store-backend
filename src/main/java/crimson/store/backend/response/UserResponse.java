package crimson.store.backend.response;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserResponse {
    private String userName;
    private String email;
    private String contactNo;
    private String name;
    private String password;
}
