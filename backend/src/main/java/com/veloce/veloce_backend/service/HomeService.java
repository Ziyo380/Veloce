package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.dto.*;
import com.veloce.veloce_backend.mapper.ProductMapper;
import com.veloce.veloce_backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HomeService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public HomeResponse getHome() {

        var products = productRepository.findAll()
                .stream()
                .map(productMapper::toDto)
                .toList();

        return HomeResponse.builder()
                .heroText("The only spirit-free aperitif that tastes as good as it makes you feel.")

                .description(
                        "Véloce is the zero-proof aperitif for modern living, crafted with super herbs and nutraceuticals to elevate your well-being, without compromising the sophisticated ritual of the aperitif."
                )

                .featuredProduct(products.isEmpty() ? null : products.get(0))

                .products(products)
                .build();
    }
}