package com.veloce.veloce_backend.service;

import com.veloce.veloce_backend.dto.StockistResponse;
import com.veloce.veloce_backend.entity.Stockist;
import com.veloce.veloce_backend.mapper.StockistMapper;
import com.veloce.veloce_backend.repository.StockistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StockistService {

    private final StockistRepository stockistRepository;
    private final StockistMapper stockistMapper;

    public List<StockistResponse> getStockists() {
        return stockistRepository.findAll()
                .stream()
                .map(stockistMapper::toDto)
                .toList();
    }
}