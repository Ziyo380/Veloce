package com.veloce.veloce_backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AboutResponse {

    private String description;
    private Integer establishedYear;
    private FounderResponse founder;
    private List<AwardResponse> awards;
    private ContactResponse contact;
}
