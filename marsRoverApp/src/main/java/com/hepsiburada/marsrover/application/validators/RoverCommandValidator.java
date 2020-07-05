package com.hepsiburada.marsrover.application.validators;


import com.hepsiburada.marsrover.domain.shared.ControlType;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class RoverCommandValidator {

    public void validate(String args) {

        if (!isNonNumeric.test(args)) throw new IllegalArgumentException(args);

        List<String> commands = Arrays.asList(args.split("(?!^)"));

        if (!isControlTypeValid.test(commands)) throw new IllegalArgumentException(args);
    }

    private Predicate<String> isNonNumeric = input -> input.matches("[a-zA-Z]+");
    private Predicate<List<String>> isControlTypeValid = input -> input.stream().allMatch(i -> EnumUtils.isValidEnum(ControlType.class, i));

}
