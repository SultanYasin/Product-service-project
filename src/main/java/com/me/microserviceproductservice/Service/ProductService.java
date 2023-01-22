package com.me.microserviceproductservice.Service;

import com.me.microserviceproductservice.DTO.ProductRequest;
import com.me.microserviceproductservice.DTO.ProductResponse;
import com.me.microserviceproductservice.Repository.ProductRepository;
import com.me.microserviceproductservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor // it will create the constructor for the class
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product); // save the product to the database

        log.info("\n Product {} created successfully \n" , product.getName()  );
    }


    public List<ProductResponse> getAllProducts() {
        //bring all products from db by using Product class and then make a map to send back only the necessary fields
         List<Product> products =  productRepository.findAll();
         Collections.reverse(products);
         return products.stream().map(product ->  mapToProductResponse(product)).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();

    }
}
