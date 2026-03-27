package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.entity.Award;
import com.veloce.veloce_backend.service.AwardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/awards")
public class AwardController {
    private final AwardService awardService;

    public AwardController(AwardService awardService) {
        this.awardService = awardService;
    }
    @GetMapping
    public List<Award> getAwards(){
        return awardService.getAllAwards();
    }
    @PostMapping
    public Award createAward(@RequestBody Award award){
        return awardService.createAward(award);
    }
}
