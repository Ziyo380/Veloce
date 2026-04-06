package com.veloce.veloce_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "founders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Founder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String imageUrl;
    private String title;
    private String phone;
    private String email;
    private String social;
}