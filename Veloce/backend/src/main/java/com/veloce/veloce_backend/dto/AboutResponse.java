package com.veloce.veloce_backend.dto;

import com.veloce.veloce_backend.entity.Award;
import com.veloce.veloce_backend.entity.Founder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class AboutResponse {

    private String description;
    private FounderResponse founder;
    private List<AwardResponse> awards;
    private ContactResponse contact;
}