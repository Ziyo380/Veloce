package com.veloce.veloce_backend.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "stockists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Stockist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String region;
    private String companyName;
    private String email;
    private String phone;
}