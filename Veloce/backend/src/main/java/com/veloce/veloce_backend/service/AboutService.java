package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.dto.AboutResponse;
import com.veloce.veloce_backend.dto.ContactResponse;
import com.veloce.veloce_backend.entity.CompanyInfo;
import com.veloce.veloce_backend.entity.Founder;
import com.veloce.veloce_backend.mapper.AwardMapper;
import com.veloce.veloce_backend.mapper.FounderMapper;
import com.veloce.veloce_backend.repository.AwardRepository;
import com.veloce.veloce_backend.repository.CompanyInfoRepository;
import com.veloce.veloce_backend.repository.FounderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class AboutService {

    private final FounderRepository founderRepository;
    private final AwardRepository awardRepository;
    private final CompanyInfoRepository companyInfoRepository;

    private final FounderMapper founderMapper;
    private final AwardMapper awardMapper;

    public AboutResponse getAbout() {

        Founder founder = founderRepository.findAll().get(0);
        CompanyInfo info = companyInfoRepository.findAll().get(0);

        AboutResponse response = new AboutResponse();

        response.setDescription(info.getDescription());

        response.setFounder(founderMapper.toDto(founder));

        response.setAwards(
                awardRepository.findAll()
                        .stream()
                        .map(awardMapper::toDto)
                        .toList()
        );

        ContactResponse contact = new ContactResponse();
        contact.setPhone(info.getPhone());
        contact.setEmail(info.getEmail());

        response.setContact(contact);

        return response;
    }
}