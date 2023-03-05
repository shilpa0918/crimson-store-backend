package crimson.store.backend.service;

import crimson.store.backend.entity.Category;
import crimson.store.backend.entity.Product;
import crimson.store.backend.entity.Store;
import crimson.store.backend.exception.CustomException;
import crimson.store.backend.repo.CategoryRepo;
import crimson.store.backend.repo.ProductRepo;
import crimson.store.backend.repo.StoreRepo;
import crimson.store.backend.request.ProductRequest;
import crimson.store.backend.request.ProductRequestOMS;
import crimson.store.backend.response.ProductDTO;
import crimson.store.backend.response.ProductResponse;
import crimson.store.backend.response.ProductResponseOMS;
import crimson.store.backend.response.ProductsByCategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    @Autowired
    CategoryRepo categoryRepo;
    @Autowired
    StoreRepo storeRepo;

    public ProductResponseOMS addProduct(ProductRequestOMS productRequest) {
        Product product = new Product();
        product.setProductName(productRequest.getProductName());
        product.setIdentifier(productRequest.getIdentifier());
        product.setImageThumb(productRequest.getImageThumb());
        product.setImageUrl(productRequest.getImageString());
        product.setListPrice(productRequest.getListPrice());
        product.setOfferPrice(productRequest.getOfferPrice());
        Category category = categoryRepo.findByCategoryName(productRequest.getCategoryName()).get();
        product.setCategory(category);
        Product addedProduct = productRepo.saveAndFlush(product);
        return convertedTOProductDto(addedProduct);
    }

    private ProductResponseOMS convertedTOProductDto(Product product) {
        ProductResponseOMS productResponse = new ProductResponseOMS();
        productResponse.setProductName(product.getProductName());
        productResponse.setIdentifier(product.getIdentifier());
      //  productResponse.setImageString(product.getImageUrl());
        System.out.println("imageUrl: "+product.getImageUrl());
        String[] imgs =  product.getImageUrl().split(";");
        List<String> images = new ArrayList<>();
        for(String img:imgs){
            images.add(img);
        }
        System.out.println("images:"+images);
        productResponse.setImageString(images);
        productResponse.setListPrice((int) product.getListPrice());
        productResponse.setOfferPrice((int) product.getOfferPrice());
        productResponse.setCategoryName(product.getCategory().getCategoryName());
        return productResponse;
    }

    public ProductsByCategoryDTO getProductsByCategory(String categoryName) {
        Optional<Category> category = categoryRepo.findByCategoryName(categoryName);
        if (category.isPresent()) {
            if (category.get().isTopCategory()) {
                throw new CustomException("no products for this category");
            } else {
                List<Product> products = productRepo.findProductsByCategoryId(category.get().getId());
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
        } else {
            throw new CustomException("no category found exception");
        }
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

    public List<ProductResponse> getProductsByCategoryAndStore(String storeName, String categoryName) {
        Store store = storeRepo.findByStoreName(storeName);
        List<ProductResponse> productResponses = new ArrayList<>();
        //get category by storeId
        Category category = categoryRepo.findByStoreId(store.getId());
        if (category.getCategoryName().equalsIgnoreCase(categoryName)) {
            //get products by categoryID
            List<Product> products = productRepo.findProductsByCategoryId(category.getId());
            productResponses = products.stream().map(product -> {
                ProductResponse productResp = new ProductResponse();
                productResp.setProductName(product.getProductName());
                productResp.setListPrice(product.getListPrice());
                productResp.setIdentifier(product.getIdentifier());
                productResp.setLongDesc(product.getLongDesc());
                productResp.setImageThumb(product.getImageThumb());
                productResp.setType(product.getType());
               // productResp.setImageString(product.getImageUrl());
                productResp.setShortDesc(product.getShortDesc());
                productResp.setOfferPrice(product.getOfferPrice());
                productResp.setListPrice(product.getListPrice());
                return productResp;
            }).collect(Collectors.toList());
        }
        return productResponses;
    }

    public List<ProductResponse> sortProduct(String sortType) {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        products.stream().forEach(product -> {
            ProductResponse productResp = new ProductResponse();
            productResp.setProductName(product.getProductName());
            productResp.setListPrice(product.getListPrice());
            productResp.setIdentifier(product.getIdentifier());
            productResp.setLongDesc(product.getLongDesc());
            productResp.setImageThumb(product.getImageThumb());
            productResp.setType(product.getType());
           // productResp.setImageString(product.getImageUrl());
            productResp.setShortDesc(product.getShortDesc());
            productResp.setOfferPrice(product.getOfferPrice());
            productResp.setListPrice(product.getListPrice());
            productResponses.add(productResp);
        });
        if (sortType.equalsIgnoreCase("productName")) {
            Collections.sort(productResponses, new Comparator<ProductResponse>() {
                @Override
                public int compare(ProductResponse o1, ProductResponse o2) {
                    return o1.getProductName().compareTo(o2.getProductName());
                }
            });
        } else if (sortType.equalsIgnoreCase("offerPrice")) {
            Collections.sort(productResponses, new Comparator<ProductResponse>() {
                @Override
                public int compare(ProductResponse o1, ProductResponse o2) {
                    return BigDecimal.valueOf(o1.getOfferPrice()).compareTo(BigDecimal.valueOf(o2.getOfferPrice()));
                }
            });
        }
        return productResponses;
    }

    public List<ProductResponse> sortProductUsingStream(String sortType) {
        List<Product> products = productRepo.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        products.stream().forEach(product -> {
            ProductResponse productResp = new ProductResponse();
            productResp.setProductName(product.getProductName());
            productResp.setListPrice(product.getListPrice());
            productResp.setIdentifier(product.getIdentifier());
            productResp.setLongDesc(product.getLongDesc());
            productResp.setImageThumb(product.getImageThumb());
            productResp.setType(product.getType());
           // productResp.setImageString(product.getImageUrl());
            productResp.setShortDesc(product.getShortDesc());
            productResp.setOfferPrice(product.getOfferPrice());
            productResp.setListPrice(product.getListPrice());
            productResponses.add(productResp);
        });
        // productResponses.stream().sorted().collect(Collectors.toList());
        List<ProductResponse> sortedProductResponses = new ArrayList<>();
        if (sortType.equalsIgnoreCase("offerPrice"))
            sortedProductResponses = productResponses.stream().sorted(Comparator.comparing(n1 -> n1.getOfferPrice())).collect(Collectors.toList());
        else if (sortType.equalsIgnoreCase("productName"))
            sortedProductResponses = productResponses.stream().sorted(Comparator.comparing(n1 -> n1.getProductName())).collect(Collectors.toList());
        return sortedProductResponses;
    }
}
