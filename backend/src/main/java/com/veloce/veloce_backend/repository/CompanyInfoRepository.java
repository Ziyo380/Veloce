package com.veloce.veloce_backend.repository;

import com.veloce.veloce_backend.entity.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, Long> {
}
