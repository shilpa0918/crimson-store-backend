package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Store;
import crimson.store.backend.repo.StoreRepo;
import crimson.store.backend.request.StoreRequest;
import crimson.store.backend.response.StoreDataResponse;
import crimson.store.backend.response.StoreResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    @Autowired
    StoreRepo storeRepo;

    public StoreResponse addStore(StoreRequest storeRequest) {
        Store store = new Store();
        store.setStoreName(storeRequest.getStoreName());
        store.setCurrency(storeRequest.getCurrency());
        store.setLanguage(storeRequest.getLanguage());
        store.setModel(storeRequest.getModel());
        store.setIdentifier(storeRequest.getIdentifier());
        Store addedStore = storeRepo.saveAndFlush(store);
        return convertedToStoreDto(addedStore);
    }

    private StoreResponse convertedToStoreDto(Store storeRequest) {
        StoreResponse store = new StoreResponse();
        store.setStoreName(storeRequest.getStoreName());
        store.setCurrency(storeRequest.getCurrency());
        store.setLanguage(storeRequest.getLanguage());
        store.setModel(storeRequest.getModel());
        store.setIdentifier(storeRequest.getIdentifier());
        List<Category> categoryS = storeRequest.getCategories();
        List<Integer> catIds = new ArrayList<>();
        if (categoryS != null) {
            categoryS.stream().map(category -> {
                return catIds.add(category.getId());
            });
            store.setCategoryIds(catIds);
        }
        return store;
    }

    public StoreDataResponse getStoreById(Integer storeId) {
        Store store = storeRepo.findById(storeId).get();
        return convertedToStoreResponse(store);

    }

    private StoreDataResponse convertedToStoreResponse(Store store) {
        StoreDataResponse storeDataResponse = new StoreDataResponse();
        storeDataResponse.setStoreName(store.getStoreName());
        storeDataResponse.setCurrency(store.getCurrency());
        storeDataResponse.setLanguage(store.getLanguage());
        storeDataResponse.setModel(store.getModel());
        storeDataResponse.setIdentifier(store.getIdentifier());
        return storeDataResponse;
    }

    public StoreDataResponse getStoreByName(String storeName) {
        Store store = storeRepo.findByStoreName(storeName);
        return convertedToStoreResponse(store);
    }

    public void deleteStoreById(Integer storeId) {
        storeRepo.deleteById(storeId);
    }
}
