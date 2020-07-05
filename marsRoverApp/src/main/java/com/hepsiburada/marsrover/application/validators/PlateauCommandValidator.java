package com.hepsiburada.marsrover.application.validators;


import com.hepsiburada.marsrover.domain.RoverDirection;
import org.apache.commons.lang3.EnumUtils;

import java.util.function.Predicate;

public class PlateauCommandValidator {

    public void validateBounds(String args) {
        String[] bounds = args.split("\\s+");

        if (!(isBoundLengthValid.and(isNumericValid).test(bounds)))
            throw new IllegalArgumentException(args);
    }

    public void validateCoordinates(String args) {
        String[] coordinates = args.split("\\s+");

        if (!(isCoordinateLengthValid.and(isNumericValid).and(isDirectionValid).test(coordinates)))
            throw new IllegalArgumentException(args);
    }

    private Predicate<String[]> isBoundLengthValid = input -> input.length == 2;
    private Predicate<String[]> isCoordinateLengthValid = input -> input.length == 3;
    private Predicate<String[]> isDirectionValid = input -> EnumUtils.isValidEnum(RoverDirection.class, input[2]);
    private Predicate<String[]> isNumericValid = input -> input[0].matches("^[0-9]+$") && input[1].matches("^[0-9]+$");
}
