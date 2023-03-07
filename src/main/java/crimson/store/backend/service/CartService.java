package crimson.store.backend.service;

import crimson.store.backend.request.CartRequest;
import crimson.store.backend.response.CartResponse;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    public CartResponse addToCart(CartRequest cartRequest) {
        CartResponse cartResponse = new CartResponse();
        return cartResponse;
    }
}
