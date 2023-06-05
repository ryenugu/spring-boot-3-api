package org.frolicbits.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.frolicbits.controller.models.ApplicationRequest;
import org.frolicbits.controller.models.AccountInfo;
import org.frolicbits.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/api")
@AllArgsConstructor
public class HomeController {
    private final ProductService productService;

    @GetMapping("/home")
    public AccountInfo home(@RequestBody ApplicationRequest applicationRequest) {
        log.debug("Home controller called");

        return productService.startApplication(applicationRequest);
    }

}
