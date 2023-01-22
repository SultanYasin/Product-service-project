package com.me.microserviceproductservice.Service;

import com.me.microserviceproductservice.DTO.ProductRequest;
import com.me.microserviceproductservice.Repository.ProductRepository;
import com.me.microserviceproductservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

        log.info("Product {} created successfully", product.getId() ,product.getName());
    }


}
