package org.frolicbits.controller.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Animal implements Soundable {
    public String name;
    public String type;
    public Dog dog;
    public Cat cat;

    @Override
    public void makeSound() {
       log.info("Animal sound");
    }
}
