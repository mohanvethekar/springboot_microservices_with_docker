package com.microservices.microservicesproject.service;

import ch.qos.logback.core.net.SyslogOutputStream;
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

    public Product updateProduct(String id , Product updatedProduct){
        Product existingproduct = productRepository.findById(id).orElse(null);//here product is optional measns if result is not found then return null else it will give error

        if(existingproduct==null){
            System.out.println("Product not found");
            return null;
        }

        existingproduct.setName(updatedProduct.getName());
        existingproduct.setDescription(updatedProduct.getDescription());
        existingproduct.setPrice(updatedProduct.getPrice());

        return  productRepository.save(existingproduct);
    }
    public Product getProductById(String id){
        Product out = productRepository.findById(id).orElse(null);

        return out;
    }

    public boolean deleteProductById(String id){
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }return false;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
