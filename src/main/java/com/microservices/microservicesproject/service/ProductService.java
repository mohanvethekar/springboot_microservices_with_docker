package com.microservices.microservicesproject.service;

import com.microservices.microservicesproject.dto.ProductRequest;
import com.microservices.microservicesproject.model.Product;
import com.microservices.microservicesproject.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    // Constructor injection (no Lombok)
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());

        productRepository.save(product);
//        System.out.println("Product saved with ID: " + product.getId());
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
