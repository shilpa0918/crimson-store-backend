package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Product;
import crimson.store.backend.repo.CategoryRepo;
import crimson.store.backend.repo.ProductRepo;
import crimson.store.backend.request.ProductRequest;
import crimson.store.backend.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;

    public ProductResponse addProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setIdentifier(productRequest.getIdentifier());
        product.setType(productRequest.getType());
        product.setImageThumb(productRequest.getImageThumb());
        product.setImageUrl(productRequest.getImageUrl());
        product.setListPrice(productRequest.getListPrice());
        product.setLongDesc(productRequest.getLongDesc());
        product.setOfferPrice(productRequest.getOfferPrice());
        product.setShortDesc(productRequest.getShortDesc());
        Category category = categoryRepo.findById(productRequest.getCategoryId()).get();
        product.setCategory(category);
        Product addedProduct = productRepo.saveAndFlush(product);
        return convertedTOProductDto(addedProduct);
    }

    private ProductResponse convertedTOProductDto(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.setProductName(product.getProductName());
        productResponse.setIdentifier(product.getIdentifier());
        productResponse.setType(product.getType());
        productResponse.setImageThumb(product.getImageThumb());
        productResponse.setImageUrl(product.getImageUrl());
        productResponse.setListPrice(product.getListPrice());
        productResponse.setLongDesc(product.getLongDesc());
        productResponse.setOfferPrice(product.getOfferPrice());
        productResponse.setShortDesc(product.getShortDesc());
        productResponse.setCategoryId(product.getCategory().getId());
        return productResponse;
    }
}
