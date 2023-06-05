package org.frolicbits.service;

import org.frolicbits.controller.models.ApplicationRequest;
import org.frolicbits.controller.models.AccountInfo;
import org.frolicbits.service.util.NameConcatenator;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class ProductService {
    public AccountInfo startApplication(ApplicationRequest applicationRequest) {

        // Create a map to associate each animal type with a corresponding builder
        Map<String, Function<ApplicationRequest, AccountInfo>> accountBuilder = new HashMap<>();
        accountBuilder.put("sdb", this::mapSDB);
        accountBuilder.put("hys", this::mapHYS);
        accountBuilder.put("cod", this::mapCOD);


        // Retrieve the appropriate builder based on the animal type
        Function<ApplicationRequest, AccountInfo> builder = accountBuilder
                .getOrDefault(applicationRequest.getProduct().getProductCode(), inputApplicationRequest -> AccountInfo.builder()
                        .errorMsg("Unknown Product Type")
                        .build());

        // Build the composite animal using the selected builder
        return builder.apply(applicationRequest);
    }

    private AccountInfo mapCOD(ApplicationRequest inputApplicationRequest) {
        return AccountInfo.builder()
                .productCode(inputApplicationRequest.getProduct().getProductType())
                .accountName("COD account")
                .accountType("Certificate of Deposit")
                .accountNumber("123456789")
                .codSpecificResponseFields(AccountInfo.CODSpecificResponseFields.builder()
                        .codInterestRate("1.5")
                        .build())
                .build();
    }

    private AccountInfo mapHYS(ApplicationRequest inputApplicationRequest) {
        return AccountInfo.builder()
                .productCode(inputApplicationRequest.getProduct().getProductType())
                .accountName("HYS account")
                .accountType("High Yield Savings")
                .accountNumber("987654321")
                .hysSpecificResponseFields(AccountInfo.HYSSpecificResponseFields.builder()
                        .hysSavingInterestRate("1.5")
                        .build())
                .build();
    }

    private AccountInfo mapSDB(ApplicationRequest inputApplicationRequest) {
        return AccountInfo.builder()
                .productCode(inputApplicationRequest.getProduct().getProductType())
                .accountName("SDB account")
                .accountType("Safe Deposit Box")
                .accountNumber("123456789")
                .accountOwner(NameConcatenator.concatenate(
                        inputApplicationRequest.getApplicants().get(0).getApplicantFirstName(),
                        inputApplicationRequest.getApplicants().get(0).getApplicantLastName(),
                        inputApplicationRequest.getApplicants().get(0).getApplicantMiddleName()))
                .sdbSpecificResponseFields(AccountInfo.SDBSpecificResponseFields.builder()
                        .sdbMonthlyFee("10")
                        .build())
                .build();
    }
}
