package crimson.store.backend.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserLoginRequest {
    private String userName;
    private String password;
}
