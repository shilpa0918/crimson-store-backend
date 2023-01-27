package crimson.store.backend.controller;

import crimson.store.backend.request.StoreRequest;
import crimson.store.backend.response.StoreDataResponse;
import crimson.store.backend.response.StoreResponse;
import crimson.store.backend.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getStoreById/{storeId}")
    public ResponseEntity getStoreById(@PathVariable String storeId) {
        StoreDataResponse storeResponse = storeService.getStoreById(Integer.valueOf(storeId));
        return new ResponseEntity(storeResponse, HttpStatus.OK);
    }
    @GetMapping("/getStoreByName/{storeName}")
    public ResponseEntity getStoreByName(@PathVariable String storeName) {
        StoreDataResponse storeResponse = storeService.getStoreByName(storeName);
        return new ResponseEntity(storeResponse, HttpStatus.OK);
    }

    @DeleteMapping("/deleteStoreById/{storeId}")
    public ResponseEntity deleteStoreById(@PathVariable String storeId){
        storeService.deleteStoreById(Integer.valueOf(storeId));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
