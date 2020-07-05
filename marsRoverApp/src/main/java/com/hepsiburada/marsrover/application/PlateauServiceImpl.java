package com.hepsiburada.marsrover.application;

import com.hepsiburada.marsrover.application.validators.PlateauCommandValidator;
import com.hepsiburada.marsrover.domain.*;
import org.apache.commons.lang3.EnumUtils;

public class PlateauServiceImpl implements PlateauService {

    private PlateauCommandValidator plateauCommandValidator;

    public PlateauServiceImpl(PlateauCommandValidator plateauCommandValidator) {
        this.plateauCommandValidator = plateauCommandValidator;
    }

    @Override
    public Plateau create(String args) {
        plateauCommandValidator.validateBounds(args);
        String[] input = args.split("\\s+");
        return new Plateau(new XBound(Integer.parseInt(input[0])), new YBound(Integer.parseInt(input[1])));
    }

    @Override
    public Rover deploy(Plateau plateau, String args) {
        plateauCommandValidator.validateCoordinates(args);

        String[] input = args.split("\\s+");
        Rover newRover = RoverFactory.create(new X(Integer.parseInt(input[0])), new Y(Integer.parseInt(input[1])), EnumUtils.getEnum(RoverDirection.class, input[2]));

        plateau.deploy(newRover);
        return newRover;
    }
}
