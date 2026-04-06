package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.dto.ProductResponse;
import com.veloce.veloce_backend.entity.Product;
import com.veloce.veloce_backend.mapper.ProductMapper;
import com.veloce.veloce_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();
    }

    public List<ProductResponse> getByCategory(String category){
        return productRepository.findAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .map(productMapper::toDto)
                .toList();
    }

    public ProductResponse getById(Long id){
        Product product=productRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
        return productMapper.toDto(product);
    }


}
