package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.dto.HomeResponse;
import com.veloce.veloce_backend.service.HomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/home")
@RequiredArgsConstructor
public class HomeController {
    private final HomeService homeService;

    @GetMapping
    public HomeResponse gethome(){
        return homeService.getHome();
    }
}
