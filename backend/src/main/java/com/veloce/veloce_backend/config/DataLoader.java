package com.veloce.veloce_backend.config;

import com.veloce.veloce_backend.entity.*;
import com.veloce.veloce_backend.repository.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final ProductRepository productRepository;
    private final FounderRepository founderRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final AwardRepository awardRepository;
    private final StockistRepository stockistRepository;

    @PostConstruct
    public void load() {

        System.out.println("🔥 DataLoader started...");

        // prevent duplicate data
        if (productRepository.count() > 0) {
            System.out.println("⚠️ Data already exists, skipping...");
            return;
        }

        System.out.println("🚀 Inserting test data...");

        // PRODUCTS
        productRepository.save(Product.builder()
                .name("Lavande")
                .description("Floral aperitif with lavender and chamomile")
                .category("floral")
                .imageUrl("/lavanda.jpg")
                .build());

        productRepository.save(Product.builder()
                .name("Primavera")
                .description("Bright citrus aperitif")
                .category("citrus")
                .imageUrl("/primavera.jpg")
                .build());

        productRepository.save(Product.builder()
                .name("Spezia")
                .description("Spiced aperitif with cinnamon")
                .category("spiced")
                .imageUrl("/spezia.jpg")
                .build());

        // FOUNDER
        founderRepository.save(Founder.builder()
                .name("Mike Vera")
                .imageUrl("/founder.jpg")
                .build());

        // COMPANY INFO
        companyInfoRepository.save(CompanyInfo.builder()
                .description("Veloce represents a new era of spirit-free aperitifs.")
                .phone("(646) 555-4567")
                .email("hello@figma.com")
                .build());

        // AWARDS
        awardRepository.save(Award.builder()
                .year(2005)
                .title("Best Botanical Blend")
                .build());

        awardRepository.save(Award.builder()
                .year(2006)
                .title("Gold Medal")
                .build());

        // STOCKISTS
        stockistRepository.save(Stockist.builder()
                .region("USA")
                .companyName("The Artisan Grocer")
                .email("hello@figma.com")
                .phone("415-555-4567")
                .build());

        stockistRepository.save(Stockist.builder()
                .region("Europe")
                .companyName("La Maison du Goût")
                .email("hello@figma.com")
                .phone("+33 1 23 45 67 89")
                .build());

        System.out.println("✅ Data inserted successfully!");
    }
}