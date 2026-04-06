package com.veloce.veloce_backend.mapper;

import com.veloce.veloce_backend.dto.AwardResponse;
import com.veloce.veloce_backend.entity.Award;
import org.springframework.stereotype.Component;

@Component
public class AwardMapper {
    public AwardResponse toDto(Award award){
        AwardResponse dto=new AwardResponse();
        dto.setYear(award.getYear());
        dto.setTitle(award.getTitle());
        return dto;

    }
}
