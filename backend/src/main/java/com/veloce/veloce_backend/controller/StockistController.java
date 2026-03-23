package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.dto.StockistResponse;
import com.veloce.veloce_backend.entity.Stockist;
import com.veloce.veloce_backend.service.StockistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/stockists")
@RequiredArgsConstructor
public class StockistController {

    private final StockistService stockistService;

    @GetMapping
    public List<StockistResponse> getStockists() {
        return stockistService.getStockists();
    }
}