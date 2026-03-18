package com.veloce.veloce_backend.controller;

import com.veloce.veloce_backend.entity.Stockist;
import com.veloce.veloce_backend.service.StockistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stockists")
public class StockistController {
    private final StockistService stockistService;

    public StockistController(StockistService stockistService) {
        this.stockistService = stockistService;
    }
    @GetMapping
    public List<Stockist> getStockist(@RequestParam(required = false) String region){
        if (region != null){
            return stockistService.getStockistsByRegion(region);
        }
        return stockistService.getAllStockist();
    }
    @PostMapping
    public Stockist createStockist(@RequestBody Stockist stockist){
        return stockistService.createStockist(stockist);
    }
}
