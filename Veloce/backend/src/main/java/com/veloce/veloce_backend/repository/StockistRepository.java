package com.veloce.veloce_backend.repository;

import com.veloce.veloce_backend.entity.Stockist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockistRepository extends JpaRepository<Stockist, Long> {
    List<Stockist> findByRegion(String region);
}
