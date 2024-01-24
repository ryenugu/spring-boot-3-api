package org.frolicbits.service;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Deployment {
    private String deploymentName;
    private List<Container> containers;

    // Omitted constructors

    // Omitted getters and setters
}
