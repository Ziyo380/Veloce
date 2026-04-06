package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.dto.AboutResponse;
import com.veloce.veloce_backend.service.AboutService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/about")
@RequiredArgsConstructor
public class AboutController {
    private final AboutService aboutService;

    @GetMapping
    public AboutResponse getAbout(){
        return aboutService.getAbout();
    }
}
