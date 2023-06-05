package org.frolicbits.controller.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInfo {
    private String productCode;

    private String errorMsg;
    private String accountNumber;
    private String accountName;
    private Integer startBalance;
    private String accountType;
    private String accountOwner;


    private SDBSpecificResponseFields sdbSpecificResponseFields;
    private HYSSpecificResponseFields hysSpecificResponseFields;
    private CODSpecificResponseFields codSpecificResponseFields;

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class SDBSpecificResponseFields {
        private String sdbMonthlyFee;

    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class HYSSpecificResponseFields {
        private String hysSavingInterestRate;

    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CODSpecificResponseFields {
        private String codInterestRate;
    }

}


