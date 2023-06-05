package org.frolicbits.controller.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationRequest {
    private Product product;
    private List<Applicant> applicants;
    public String accountNumber;
    public SDBSpecificRequestFields sdbRequest;
    public HYSSpecificRequestFields hysSpecificRequestFields;
    public CODSpecificRequestFields codSpecificRequestFields;


}
