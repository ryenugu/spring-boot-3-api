package org.frolicbits.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Container {
    private String name;
    private String buildDate;
    private String imageVersion;
    private String repo;
    private String imageTag; // Added field



    // Constructor (if needed)

    // Omitted getters and setters
}
