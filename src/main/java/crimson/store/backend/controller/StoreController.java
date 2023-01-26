package crimson.store.backend.controller;

import crimson.store.backend.request.StoreRequest;
import crimson.store.backend.response.StoreResponse;
import crimson.store.backend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StoreController {

    @Autowired
    StoreService storeService;

    @PostMapping("/addStore")
    public ResponseEntity addStore(@RequestBody StoreRequest storeRequest) {
        StoreResponse storeResponse = storeService.addStore(storeRequest);
        return new ResponseEntity(storeResponse, HttpStatus.CREATED);
    }


}
