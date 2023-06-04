package org.frolicbits.service;

import org.frolicbits.controller.models.Animal;
import org.frolicbits.controller.models.Cat;
import org.frolicbits.controller.models.Dog;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class AnimalService {
    public Animal buildAnimal(Animal animal) {
        // Create a map to associate each animal type with a corresponding builder
        Map<String, Function<Animal, Animal>> builderMap = new HashMap<>();
        builderMap.put("Dog", inputAnimal -> Animal.builder()
                .name("Snoop Dogg")
                .type("Dog")
                .dog(Dog.builder().breed("Pug").build())
                .build());
        builderMap.put("Cat", inputAnimal -> Animal.builder()
                .name("Mr Whiskers ")
                .type("Cat")
                .cat(Cat.builder().breed("Siamese").build())
                .build());

        // Retrieve the appropriate builder based on the animal type
        Function<Animal, Animal> builder = builderMap.getOrDefault(animal.getType(), inputAnimal -> Animal.builder()
                .name("Unknown Animal")
                .type(animal.getType())
                .build());

        // Build the composite animal using the selected builder
        return builder.apply(animal);

    }
}
