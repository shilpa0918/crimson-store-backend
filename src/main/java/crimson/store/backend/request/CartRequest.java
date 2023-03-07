package crimson.store.backend.request;

import crimson.store.backend.entity.CartItem;
import crimson.store.backend.entity.Users;
import lombok.*;

import java.util.List;

@Setter
@Getter
public class CartRequest {
    private int id;
    private Users users;
    private int qty;
    private List<CartItemRequest> cartItems;
}
