package com.veloce.veloce_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String imageUrl;


}
