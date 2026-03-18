package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.entity.Product;
import com.veloce.veloce_backend.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    public Product getProduct(Long id){
        return productRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Product not found"));
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
