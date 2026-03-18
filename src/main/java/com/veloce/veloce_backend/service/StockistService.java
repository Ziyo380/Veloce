package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.entity.Stockist;
import com.veloce.veloce_backend.repository.StockistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockistService {
    private final StockistRepository stockistRepository;

    public StockistService(StockistRepository stockistRepository) {
        this.stockistRepository = stockistRepository;
    }

    public List<Stockist> getAllStockist(){
        return stockistRepository.findAll();
    }
    public List<Stockist> getStockistsByRegion(String region){
        return stockistRepository.findByRegion(region);
    }
    public Stockist createStockist(Stockist stockist){
        return stockistRepository.save(stockist);
    }
}
