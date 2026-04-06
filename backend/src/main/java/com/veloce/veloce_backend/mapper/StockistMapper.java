package com.veloce.veloce_backend.mapper;

import com.veloce.veloce_backend.dto.StockistResponse;
import com.veloce.veloce_backend.entity.Stockist;
import org.springframework.stereotype.Component;

@Component
public class StockistMapper {
    public StockistResponse toDto(Stockist s){
        StockistResponse dto=new StockistResponse();
        dto.setRegion(s.getRegion());
        dto.setCompanyName(s.getCompanyName());
        dto.setEmail(s.getEmail());
        dto.setPhone(s.getPhone());
        return dto;
    }
}
