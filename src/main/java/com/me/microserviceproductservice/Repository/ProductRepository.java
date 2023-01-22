package com.me.microserviceproductservice.Repository;

import com.me.microserviceproductservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
