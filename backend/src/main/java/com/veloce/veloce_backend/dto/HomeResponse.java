package com.veloce.veloce_backend.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeResponse {

    private String heroText;

    private String description;   // 👈 добавили

    private ProductResponse featuredProduct;

    private List<ProductResponse> products;
}