package com.hepsiburada.marsrover.application;


import com.hepsiburada.marsrover.application.validators.RoverCommandValidator;
import com.hepsiburada.marsrover.domain.Plateau;
import com.hepsiburada.marsrover.domain.Rover;
import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Collections;
import java.util.stream.Stream;


public class RoverServiceImpl implements RoverService {

    private RoverCommandValidator roverCommandValidator;

    public RoverServiceImpl(RoverCommandValidator roverCommandValidator) {
        this.roverCommandValidator = roverCommandValidator;
    }

    @Override
    public Rover.Result control(Plateau plateau, Rover rover, String args) {
        this.roverCommandValidator.validate(args);

        String[] commands = args.split("(?!^)");

       return Stream.of(commands).map(cmd -> executeCommand(plateau, rover, cmd))
                .reduce((first, second) -> second)
                .orElse(null);
    }

    private Rover.Result executeCommand(Plateau plateau, Rover rover, String cmd) {
        switch (cmd) {
            case "L":
                return rover.turnLeft();
            case "R":
                return rover.turnRight();
            default:
                return rover.move(plateau.getXBound().getValue(), plateau.getYBound().getValue());
        }
    }
}
