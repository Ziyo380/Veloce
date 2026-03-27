package com.veloce.veloce_backend.mapper;

import com.veloce.veloce_backend.dto.FounderResponse;
import com.veloce.veloce_backend.entity.Founder;
import org.springframework.stereotype.Component;

@Component
public class FounderMapper {
    public FounderResponse toDto(Founder founder){
        FounderResponse dto=new FounderResponse();
        dto.setName(founder.getName());
        dto.setImageUrl(founder.getImageUrl());
        return dto;
    }
}
