package com.hepsiburada.marsrover.domain;


public class RoverFactory {
    private RoverFactory() {
    }

    public static Rover create(X x, Y y, RoverDirection roverDirection) {
        return new Rover(RoverId.generate(),
                new RoverPosition(x, y),
                roverDirection);
    }
}
