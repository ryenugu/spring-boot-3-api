package org.frolicbits.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/api")
@AllArgsConstructor
public class FoodController {

    @GetMapping("/food")
    public ProductResponse generateSample() {
        return ProductResponse.builder()
                .name("Burger")
                .description("Burger with cheese")
                .price("10")
                .category("Fast Food")
                .image("https://www.google.com/url?sa=i&url=https%3A")
                .build();

    }


    @Data
    @Builder
    private static class ProductResponse {
        private String name;
        private String description;
        private String price;
        private String category;
        private String image;


    }
}
