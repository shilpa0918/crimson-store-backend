package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Product;
import crimson.store.backend.exception.CustomException;
import crimson.store.backend.repo.CategoryRepo;
import crimson.store.backend.repo.ProductRepo;
import crimson.store.backend.request.ProductRequest;
import crimson.store.backend.response.ProductDTO;
import crimson.store.backend.response.ProductResponse;
import crimson.store.backend.response.ProductsByCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public ProductsByCategoryDTO getProductsByCategory(String categoryName) {
        Category category = categoryRepo.findByCategoryName(categoryName);
        List<Product> products = productRepo.findProductsByCategoryId(category.getId());
        int productCount = products.size();
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductsByCategoryDTO productsByCategoryDTO = new ProductsByCategoryDTO();
        System.out.println(products);
        productDTOS = products.stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(product.getProductName());
            productDTO.setIdentifier(product.getIdentifier());
            productDTO.setType(product.getType());
            productDTO.setListPrice(product.getListPrice());
            productDTO.setImageUrl(product.getImageUrl());
            productDTO.setImageThumb(product.getImageThumb());
            productDTO.setOfferPrice(product.getOfferPrice());
            productDTO.setLongDesc(product.getLongDesc());
            productDTO.setShortDesc(product.getShortDesc());
            return productDTO;
        }).collect(Collectors.toList());
        productsByCategoryDTO.setProductCount(productCount);
        productsByCategoryDTO.setProducts(productDTOS);
        return productsByCategoryDTO;
    }

    public ProductsByCategoryDTO getTopCategoryProducts(Boolean topCategory) {
        Category category = categoryRepo.findByTopCategory(topCategory);
        if (category == null)
            throw new CustomException("Category does not have data!!");
        List<Product> products = productRepo.findProductsByCategoryId(category.getId());
        int productCount = products.size();
        List<ProductDTO> productDTOS = new ArrayList<>();
        ProductsByCategoryDTO productsByCategoryDTO = new ProductsByCategoryDTO();
        System.out.println(products);
        productDTOS = products.stream().map(product -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setProductName(product.getProductName());
            productDTO.setIdentifier(product.getIdentifier());
            productDTO.setType(product.getType());
            productDTO.setListPrice(product.getListPrice());
            productDTO.setImageUrl(product.getImageUrl());
            productDTO.setImageThumb(product.getImageThumb());
            productDTO.setOfferPrice(product.getOfferPrice());
            productDTO.setLongDesc(product.getLongDesc());
            productDTO.setShortDesc(product.getShortDesc());
            return productDTO;
        }).collect(Collectors.toList());
        productsByCategoryDTO.setProductCount(productCount);
        productsByCategoryDTO.setProducts(productDTOS);
        return productsByCategoryDTO;
    }
}
