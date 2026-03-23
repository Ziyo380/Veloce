package com.veloce.veloce_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HomeResponse {
    private String heroText;
    private ProductResponse featuredProduct;
    private List<ProductResponse> products;
}
