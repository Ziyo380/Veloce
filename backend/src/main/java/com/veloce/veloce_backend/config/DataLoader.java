package com.veloce.veloce_backend.config;

import com.veloce.veloce_backend.entity.*;
import com.veloce.veloce_backend.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final FounderRepository founderRepository;
    private final AwardRepository awardRepository;
    private final StockistRepository stockistRepository;
    private final CompanyInfoRepository companyInfoRepository;

    @Override
    public void run(String... args) {

        // ❗ защита от дублирования
        if (productRepository.count() > 0) {
            System.out.println("⚠️ Data already exists, skipping initialization...");
            return;
        }

        System.out.println("🔥 Loading initial data...");

        // =========================
        // PRODUCTS
        // =========================

        productRepository.save(Product.builder()
                .name("Lavande")
                .description("A delicate floral aperitif with notes of lavender and chamomile.")
                .category("floral")
                .imageUrl("/cart_1.jpg")
                .subtitle("A delicate floral aperitif with notes of lavender and chamomile.")
                .build());

        productRepository.save(Product.builder()
                .name("Primavera")
                .description("A refreshing and vibrant aperitif with bright citrus notes.")
                .category("citrus")
                .imageUrl("/cart_2.jpg")
                .subtitle("A bold, spiced aperitif featuring cardamom, ginger, and cinnamon.")
                .build());

        productRepository.save(Product.builder()
                .name("Spezia")
                .description("A bold, spiced aperitif featuring cardamom, ginger, and cinnamon.")
                .category("spiced")
                .imageUrl("/cart_3.jpg")
                .subtitle("A bold, spiced aperitif featuring cardamom, ginger, and cinnamon.")
                .build());

        // =========================
        // FOUNDER
        // =========================
        founderRepository.save(Founder.builder()
                .name("Mike Vera")
                .title("Founder")
                .phone("415-555-4567")
                .email("hello@figma.com")
                .social("@figma")
                .imageUrl("/bg_4.jpg")
                .build());

        // =========================
        // COMPANY INFO
        // =========================
        companyInfoRepository.save(CompanyInfo.builder()
                .description("Véloce represents a new era of the aperitif, where flavor and functionality converge in a beautifully crafted, alcohol-free beverage.")
                .phone("415-555-4567")
                .email("hello@figma.com")
                .establishedYear(2022)
                .build());

        // =========================
        // AWARDS
        // =========================
        awardRepository.save(Award.builder().year(2025).title("Best Botanical Blend").build());
        awardRepository.save(Award.builder().year(2025).title("Gold Medal – Bittersweet Category").build());
        awardRepository.save(Award.builder().year(2024).title("Best Sustainable Packaging").build());
        awardRepository.save(Award.builder().year(2024).title("Eco-Friendly Brand of the Year").build());
        awardRepository.save(Award.builder().year(2023).title("Editor's Choice – Best Aperitif").build());
        awardRepository.save(Award.builder().year(2023).title("Most Elegant Bottle Design").build());
        awardRepository.save(Award.builder().year(2022).title("Best Low & No Alcohol Beverage").build());

        // =========================
        // STOCKISTS
        // =========================
        stockistRepository.save(Stockist.builder()
                .region("USA")
                .companyName("The Artisan Grocer")
                .email("hello@figma.com")
                .phone("415-555-4567")
                .build());

        stockistRepository.save(Stockist.builder()
                .region("Europe")
                .companyName("Le Marché Bio")
                .email("hello@figma.com")
                .phone("+33 1 23 45 67 89")
                .build());

        stockistRepository.save(Stockist.builder()
                .region("Asia")
                .companyName("Kurasu & Co.")
                .email("hello@figma.com")
                .phone("+81 3 1234 5678")
                .build());

        System.out.println("✅ Data inserted successfully!");
    }
}
