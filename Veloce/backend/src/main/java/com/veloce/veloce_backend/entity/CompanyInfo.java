package com.veloce.veloce_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "company_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String phone;
    private String email;
}
