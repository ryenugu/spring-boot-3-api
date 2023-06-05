package org.frolicbits.controller.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Applicant {
    private String applicantFirstName;
    private String applicantLastName;
    private String applicantMiddleName;

    private String ownershipType;
    private String applicantIdentifier;
}
