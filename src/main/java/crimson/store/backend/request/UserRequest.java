package crimson.store.backend.request;

import lombok.*;

@Setter
@Getter
public class UserRequest {
    private String userName;
    private String email;
    private String contactNo;
    private String name;
    private String password;
}
