package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.entity.Award;
import com.veloce.veloce_backend.repository.AwardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AwardService {
    private final AwardRepository awardRepository;

    public AwardService(AwardRepository awardRepository) {
        this.awardRepository = awardRepository;
    }
    public List<Award> getAllAwards(){
        return awardRepository.findAll();
    }
    public Award createAward(Award award){
        return awardRepository.save(award);
    }
}
