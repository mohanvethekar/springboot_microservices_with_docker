package com.microservices.microservicesproject.repository;

import com.microservices.microservicesproject.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
