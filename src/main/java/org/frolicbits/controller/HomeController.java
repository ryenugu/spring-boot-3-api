package org.frolicbits.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.frolicbits.controller.models.Animal;
import org.frolicbits.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/v1/api")
@AllArgsConstructor
public class HomeController {
    private final AnimalService animalService;

    @GetMapping("/home")
    public Animal home(@RequestBody Animal animal) {
        log.debug("Home controller called");

        return animalService.buildAnimal(animal);
    }

}
