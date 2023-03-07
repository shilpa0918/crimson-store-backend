package crimson.store.backend.request;

import crimson.store.backend.entity.Cart;
import crimson.store.backend.entity.CartItem;
import crimson.store.backend.entity.Product;
import crimson.store.backend.entity.Users;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.util.List;

@Setter
@Getter
public class CartItemRequest {
    private int id;
    private Product product;
    private Cart cart;
    private int qty;
}
