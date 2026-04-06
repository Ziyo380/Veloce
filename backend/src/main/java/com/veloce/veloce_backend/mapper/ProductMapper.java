package com.veloce.veloce_backend.mapper;

import com.veloce.veloce_backend.dto.ProductResponse;
import com.veloce.veloce_backend.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductResponse toDto(Product product){
        ProductResponse dto=new ProductResponse();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setImageUrl(product.getImageUrl());
        dto.setSubtitle(product.getSubtitle());

        return dto;
    }
}
