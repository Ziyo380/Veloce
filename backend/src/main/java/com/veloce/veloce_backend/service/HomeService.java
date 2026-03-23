package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.dto.HomeResponse;
import com.veloce.veloce_backend.entity.Product;
import com.veloce.veloce_backend.mapper.ProductMapper;
import com.veloce.veloce_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HomeService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public HomeResponse getHome() {

        List<Product> products = productRepository.findAll();

        Product featured = products.stream()
                .filter(p -> p.getName().equalsIgnoreCase("Primavera"))
                .findFirst()
                .orElse(products.get(0));

        HomeResponse response = new HomeResponse();

        response.setHeroText("The only spirit-free aperitif for modern living.");

        response.setFeaturedProduct(productMapper.toDto(featured));

        response.setProducts(
                products.stream()
                        .map(productMapper::toDto)
                        .toList()
        );

        return response;
    }
}