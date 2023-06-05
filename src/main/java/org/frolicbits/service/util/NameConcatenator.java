package org.frolicbits.service.util;

import java.util.StringJoiner;
import java.util.stream.Stream;

public class NameConcatenator {
    public static String concatenate(String firstName, String middleName, String lastName) {
        StringJoiner joiner = new StringJoiner(" ");

        Stream.of(firstName, middleName, lastName)
                .filter(s -> s != null && !s.trim().isEmpty())
                .forEach(joiner::add);

        return joiner.toString();
    }
}
