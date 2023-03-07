package crimson.store.backend.controller;

import crimson.store.backend.request.CartRequest;
import crimson.store.backend.response.CartResponse;
import crimson.store.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart/api/v1")
public class CartController {

    @Autowired
    CartService cartService;
    @PostMapping("/cart")
    public ResponseEntity addToCart(@RequestBody CartRequest cartRequest){
        CartResponse cartResponse = cartService.addToCart(cartRequest);
        return new ResponseEntity(cartResponse, HttpStatus.CREATED);
    }
}
