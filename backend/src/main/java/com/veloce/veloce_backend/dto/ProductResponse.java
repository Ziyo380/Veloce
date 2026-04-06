package com.veloce.veloce_backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor     // 👈 ОБЯЗАТЕЛЬНО
@AllArgsConstructor
@Builder
public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private String category;
    private String imageUrl;
    private String subtitle;



}
