package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.dto.ProductResponse;
import com.veloce.veloce_backend.entity.Product;
import com.veloce.veloce_backend.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;


    @GetMapping
    public List<ProductResponse> getAll(@RequestParam(required = false) String category){
    if (category !=null){
    return productService.getByCategory(category);
    }
    return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getById(@PathVariable Long id){
        return productService.getById(id);
    }
}
