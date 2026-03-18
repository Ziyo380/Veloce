package com.veloce.veloce_backend.repository;

import com.veloce.veloce_backend.entity.Award;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AwardRepository extends JpaRepository<Award, Long> {
}
