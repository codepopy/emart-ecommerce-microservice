package com.ecom.microservices.productService.repository;

import com.ecom.microservices.productService.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
