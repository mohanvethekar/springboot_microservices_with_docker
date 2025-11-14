package com.microservices.microservicesproject.controller;

import com.microservices.microservicesproject.dto.ProductRequest;
import com.microservices.microservicesproject.model.Product;
import com.microservices.microservicesproject.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    // Constructor injection
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
        return "Product created successfully!";
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id , @RequestBody Product updatedproduct){
        Product updated = productService.updateProduct(id , updatedproduct);

        if(updated!=null){
            return ResponseEntity.ok(updated);
        }else{
            return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable String id){
        if(productService.deleteProductById(id)){
            return "Product Deleted Successfully";
        }else{
            return "Product not deleted successfully";
        }
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }
}
