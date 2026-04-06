package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.entity.Founder;
import com.veloce.veloce_backend.repository.FounderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FounderService {
    private final FounderRepository founderRepository;

    public FounderService(FounderRepository founderRepository) {
        this.founderRepository = founderRepository;
    }
    public List<Founder> getAllFounders(){
        return founderRepository.findAll();
    }
    public Founder createFounder(Founder founder){
        return founderRepository.save(founder);
    }
}
