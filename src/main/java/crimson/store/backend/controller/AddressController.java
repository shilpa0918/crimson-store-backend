package crimson.store.backend.controller;

import crimson.store.backend.request.AddressRequest;
import crimson.store.backend.request.CartRequest;
import crimson.store.backend.response.AddressResponse;
import crimson.store.backend.response.CartResponse;
import crimson.store.backend.service.AddressService;
import crimson.store.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address/api/v1")
public class AddressController {

    @Autowired
    AddressService addressService;
    @PostMapping("/address")
    public ResponseEntity addAddress(@RequestBody AddressRequest addressRequest){
        AddressResponse addressResponse = addressService.addAddress(addressRequest);
        return new ResponseEntity(addressResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{userId}")
    public ResponseEntity getAddressByUserId(@PathVariable String userId){
        List<AddressResponse> addressResponse = addressService.getAddressByUserId((userId));
        return new ResponseEntity(addressResponse, HttpStatus.OK);
    }
    @GetMapping("/getAddressByUserName/{userName}")
    public ResponseEntity getAddressByUserName(@PathVariable String userName){
        List<AddressResponse> addressResponse = addressService.getAddressByUserName(userName);
        return new ResponseEntity(addressResponse, HttpStatus.OK);
    }
}
