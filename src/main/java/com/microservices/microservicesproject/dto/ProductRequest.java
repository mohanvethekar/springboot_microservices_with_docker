package com.microservices.microservicesproject.dto;

import java.math.BigDecimal;

// Java 21 record – simpler DTO, no Lombok needed
public record ProductRequest(
        String name,
        String description,
        BigDecimal price
) {}
