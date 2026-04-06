package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.entity.Founder;
import com.veloce.veloce_backend.service.FounderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/founders")
public class FounderController {
    private final FounderService founderService;

    public FounderController(FounderService founderService) {
        this.founderService = founderService;
    }
    @GetMapping
    public List<Founder> getFounders(){
        return founderService.getAllFounders();
    }
    @PostMapping
    public Founder createFounder(@RequestBody Founder founder){
        return founderService.createFounder(founder);
    }
}
